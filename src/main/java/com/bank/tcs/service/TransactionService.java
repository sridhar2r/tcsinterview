package com.bank.tcs.service;

import com.bank.tcs.model.Transaction;

import java.util.List;

/**
 * Created by sridharrajagopal on 9/15/20.
 */
public interface TransactionService {
    double getTotalIncome(List<Transaction> transactions);
    double getTotalExpense(List<Transaction> transactions);
    String getTopExpenseMonth(List<Transaction> transactions);
    double getTotalSavings(List<Transaction> transactions);
}
