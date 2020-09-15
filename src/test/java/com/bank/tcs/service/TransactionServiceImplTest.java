package com.bank.tcs.service;

import com.bank.tcs.model.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by sridharrajagopal on 9/15/20.
 */
@RunWith(JUnit4.class)
public class TransactionServiceImplTest {
    private TransactionService transactionService;
    @Before
    public void setUp() throws Exception {
        transactionService = new TransactionServiceImpl();
    }

    @Test
    public void getTotalIncome_whenIncomeIsNotPresent_ReturnsNull() throws Exception {
        Transaction transaction = Transaction.builder().txnDate(LocalDate.now()).amt(-200.3).transactionType("Trial").build();
        Transaction transaction1 = Transaction.builder().txnDate(LocalDate.now().minusDays(1)).amt(-300.3).transactionType("Trial1").build();
        List<Transaction> list = new ArrayList<>(Arrays.asList(transaction, transaction1));

        double totalIncome = transactionService.getTotalIncome(list);

        assertThat(totalIncome, is(0.0));
    }



}