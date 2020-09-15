package com.bank.tcs.model;

import lombok.*;

import java.time.LocalDate;

/**
 * Created by sridharrajagopal on 9/15/20.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Transaction {
    private LocalDate txnDate;
    private Double amt;
    private String transactionType;


}
