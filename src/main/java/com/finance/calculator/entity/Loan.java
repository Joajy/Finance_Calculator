package com.finance.calculator.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Loan {

    private long amount;
    private int year;
    private double interestRate;
    private String loanType;
}
