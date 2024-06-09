package com.finance.calculator.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Saving {

    private long amount;
    private int term;
    private double interestRate;
}
