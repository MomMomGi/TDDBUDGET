package BudgetService;

import Budget.Budget;

import java.time.LocalDate;

public class BudgetService {
    public double query(LocalDate start, LocalDate end) {

        IBudgetRepo.getAll();

        return 1000.00;
    }

    private class IBudgetRepo {
       return List<Budget>;
    }
}
