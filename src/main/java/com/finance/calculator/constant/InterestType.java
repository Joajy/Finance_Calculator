package com.finance.calculator.constant;

//단리, 복리 여부를 확인하여 결과를 제공합니다.
public class InterestType {

    public static double savingAppliedInterest(String s, double rate, int year){
        rate /= 12;
        //compound
        return switch (s) {
            case "yearCompound" -> Math.pow(1 + rate, year);
            case "sixMonthCompound" -> Math.pow(1 + rate, year << 1);
            case "threeMonthCompound" -> Math.pow(1 + rate, year << 2);
            case "everyMonthCompound" -> Math.pow(1 + rate, year * 12);
            default ->
                //simple
                    1 + (rate * 12) * year;
        };
    }

    public static double depositAppliedInterest(String s, double rate, int year){
        int month = year * 12;
        double val = 1 + rate / 12;
        //compound
        return switch (s) {
            case "yearCompound" ->
                    val * (Math.pow(val, month / 12) - 1) / (val - 1) * month;
            case "sixMonthCompound" ->
                    val * (Math.pow(val, month / 6) - 1) / (val - 1) * (month >> 1);
            case "threeMonthCompound" ->
                    val * (Math.pow(val, month / 3) - 1) / (val - 1) * (month >> 2);
            case "everyMonthCompound" ->
                    val * (Math.pow(val, month) - 1) / (val - 1);
            default ->
                //simple
                    (year * 12) + (rate * (year * 12 + 1) * year * 12 / 2) / 12;
        };
    }
}
