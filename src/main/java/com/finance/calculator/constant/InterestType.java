package com.finance.calculator.constant;

//단리, 복리 여부를 확인하여 결과를 제공합니다.
public class InterestType {

    public static double appliedInterest(String s, double rate, int year){
        rate /= 12;
        //compound = P * (1 + InterestRate) ^ year
        return switch (s) {
            case "yearCompound" -> Math.pow(1 + rate, year);
            case "sixMonthCompound" -> Math.pow(1 + rate, year << 1);
            case "threeMonthCompound" -> Math.pow(1 + rate, year << 2);
            case "everyMonthCompound" -> Math.pow(1 + rate, year * 12);
            default ->
                //simple = P * (1 + InterestRate * year)
                    1 + (rate * 12) * year;
        };
    }
}
