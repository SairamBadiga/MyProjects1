package com.badiga.esa.strategies;

import com.badiga.esa.models.Expense;

import java.util.List;
public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expenses);

}