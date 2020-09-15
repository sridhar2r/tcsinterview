package com.bank.tcs.driver;

import com.bank.tcs.model.Transaction;
import com.bank.tcs.service.TransactionService;
import com.bank.tcs.service.TransactionServiceImpl;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sridharrajagopal on 9/15/20.
 */
public class TransactionDriver {
    @Getter
    @Setter
    private TransactionService transactionService;
    public static void main(String[] args) {

        TransactionDriver driver = new TransactionDriver();
        List<Transaction> transactions = driver.getTransactions();
        driver.setTransactionService(new TransactionServiceImpl());
        System.out.println("Total Income: "+driver.getTransactionService().getTotalIncome(transactions));
    }

    private  List<Transaction> getTransactions() {
        String line;
        List<Transaction> list = new ArrayList<>();
        String fileName = System.getProperty("user.dir") + "/Transactions.txt";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            while ((line = bufferedReader.readLine()) != null) {
                String[] txns = line.split(",");
                list.add(Transaction.builder()
                        .txnDate(LocalDate.parse(txns[0], formatter))
                        .amt(Double.parseDouble(txns[1]))
                        .transactionType(txns[2])
                        .build());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

}
