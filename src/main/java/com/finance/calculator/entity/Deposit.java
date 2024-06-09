package com.finance.calculator.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Deposit {

    private long amount;
    private int term;
    private double interestRate;
    private String interestType;

}
