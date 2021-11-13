package entity;

public class Budget {
    String YearMonth;
    int Amount;

    public Budget(String yearMonth, int amount) {
        YearMonth = yearMonth;
        Amount = amount;
    }

    public String getYearMonth() {
        return YearMonth;
    }

    public void setYearMonth(String yearMonth) {
        YearMonth = yearMonth;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}
