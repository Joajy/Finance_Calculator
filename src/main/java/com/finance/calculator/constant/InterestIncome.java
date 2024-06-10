package com.finance.calculator.constant;

public class InterestIncome {
    private static final double GENERAL = 15.4;
    private static final double TAXBREAK = 9.5;

    public static double type(String s){
        if(s.equals("normal")) return 100 - GENERAL;
        else if(s.equals("preferential")) return 100 - TAXBREAK;
        return 100;
    }
}
