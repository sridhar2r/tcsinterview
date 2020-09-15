package com.bank.tcs.service;

import com.bank.tcs.model.Transaction;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sridharrajagopal on 9/15/20.
 */
public class TransactionServiceImpl implements TransactionService {
    @Override
    public double getTotalIncome(List<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> transaction.getAmt() > 0)
                .collect(Collectors.summingDouble(transaction -> transaction.getAmt()));
    }

    @Override
    public double getTotalExpense(List<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> transaction.getAmt() < 0)
                .collect(Collectors.summingDouble(transaction -> transaction.getAmt()));
    }

    @Override
    public String getTopExpenseMonth(List<Transaction> transactions) {
        return null;
    }

    @Override
    public double getTotalSavings(List<Transaction> transactions) {
        return 0;
    }
}
