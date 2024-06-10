package com.finance.calculator.constant;

//단리, 복리 여부를 확인하여 결과를 제공합니다.
public class InterestType {

    public static double appliedInterest(String s, double rate, int year){
        //compound = P * (1 + InterestRate) ^ year
        if(s.equals("compound")) return Math.pow(1 + rate, year);
        //simple = P * (1 + InterestRate * year)
        return 1 + rate * year;
    }
}
