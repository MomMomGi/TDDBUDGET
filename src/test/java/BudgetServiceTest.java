import BudgetService.BudgetService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetServiceTest {
    @Test
    public void singleMonth(){
        BudgetService budgetService = new BudgetService();
        assertEquals(1000.00,
                budgetService.query(
                        LocalDate.parse("2021-11-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        LocalDate.parse("2021-11-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"))));

    }

}
