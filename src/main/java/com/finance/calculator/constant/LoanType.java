package com.finance.calculator.constant;

public class LoanType {

    public static double selectLoanType(String s, double rate, int year){
        //원리금균등분할상환
        //P * (rate / 12) * (1 + (rate / 12)) ^ n / (1+rate/12)^n - 1
//        if(s.equals("eia")) return Math.pow(1 + rate, year);
        if(s.equals("eia")) return eia(rate, year);
        //원금균등분할상환
        else if(s.equals("epa")) return Math.pow(1 + rate, year);
        //만기일시상환(bullet)
        return 1 + rate * year;
    }

    private static double eia(double rate, int year) {
        double monthlyRate = rate / 12;
        double month = year * 12;
        double denominator = Math.pow((1 + monthlyRate), month);
        return monthlyRate * denominator / (denominator - 1);
    }

    private static double epa(double rate, int year) {
        double monthlyRate = rate / 12;
        double month = year * 12;
        double denominator = Math.pow((1 + monthlyRate), month);
        return monthlyRate * denominator / (denominator - 1);
    }

}
