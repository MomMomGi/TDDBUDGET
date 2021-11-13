package service;
import entity.Budget;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;

public class BudgetService {
    private IBudgetRepo repo;

    public BudgetService(IBudgetRepo repo) {

        this.repo = repo;
    }

    public double query(LocalDate start, LocalDate end) {
        List<Budget> all = repo.getAll();
        long diff = DAYS.between(start,end)+1;
        long monthDiff = end.getMonthValue() - start.getMonthValue();
        if (monthDiff == 0) {
            for (Budget b : all) {
                YearMonth ym = YearMonth.from(start);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMM");
                if (b.getYearMonth().equals(ym.format(dtf))) {

                    return b.getAmount() * diff / ym.lengthOfMonth();
                }
            }
        }
        else {
            Map<Long,Long> bMap = new HashMap<>();

            for(long month = start.getMonthValue();month<= end.getMonthValue();month++){
               int lastDay = YearMonth.from(start).lengthOfMonth();
               long days = lastDay - start.getDayOfMonth() +1;
               bMap.put(month,days);
            }
            double result = 0;
            for(Budget b : all) {
             if (bMap.get(b.getYearMonth())!=null){
                 result += b.getAmount()* bMap.get(b)/YearMonth.of(Integer.valueOf(b.getYearMonth().substring(0,4)),Integer.valueOf(b.getYearMonth().substring(4,6))).lengthOfMonth();
             }
            }
            return result;
        }
//        int dayOfMonth
        return 0;

//        return Double.valueOf(all.get(0).getAmount());
    }
}
