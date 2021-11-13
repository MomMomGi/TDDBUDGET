package service;

import entity.Budget;

import java.util.List;

public interface IBudgetRepo {
    List<Budget> getAll();
}
