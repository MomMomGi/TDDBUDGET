import entity.Budget;
import service.BudgetService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.IBudgetRepo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BudgetServiceTest {


    @Test
    public void singleMonth(){
        List<Budget> bList = new ArrayList<Budget>();
        bList.add(new Budget("202111",3000));
        IBudgetRepo repo = mock(IBudgetRepo.class);
        when(repo.getAll()).thenReturn(bList);

        BudgetService budgetService = new BudgetService(repo);
        assertEquals(3000.00,
                budgetService.query(
                        LocalDate.of(2021,11,1),
                        LocalDate.of(2021,11,30)));

    }

    @Test
    public void partialMonth(){
        List<Budget> bList = new ArrayList<Budget>();
        bList.add(new Budget("202111",3000));
        bList.add(new Budget("202112",3100));
        IBudgetRepo repo = mock(IBudgetRepo.class);
        when(repo.getAll()).thenReturn(bList);
        BudgetService budgetService = new BudgetService(repo);
        assertEquals(300.00,
                budgetService.query(
                        LocalDate.of(2021,11,2),
                        LocalDate.of(2021,11,4)));
    }

    @Test
    public void crossMonth(){
        List<Budget> bList = new ArrayList<Budget>();
        bList.add(new Budget("202111",3000));
        bList.add(new Budget("202112",6200));
        IBudgetRepo repo = mock(IBudgetRepo.class);
        when(repo.getAll()).thenReturn(bList);
        BudgetService budgetService = new BudgetService(repo);
        assertEquals(500.00,
                budgetService.query(
                        LocalDate.of(2021,11,30),
                        LocalDate.of(2021,12,2)));
    }
}
