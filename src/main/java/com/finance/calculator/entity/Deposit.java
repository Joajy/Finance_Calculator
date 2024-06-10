package com.finance.calculator.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Deposit {

    private long amount;
    private int year;
    private double interestRate;
    private String interestType;
    private String interestIncome;

    public double getAmount(int year) {
        return amount * year * 12;
    }
}
