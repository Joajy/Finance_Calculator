package com.finance.calculator.constant;

//이제에 대한 세금을 고려하여 결과를 반환합니다.
public class InterestIncome {
    private static final double GENERAL = 15.4;
    private static final double TAXBREAK = 9.5;

    public static double type(String s){
        if(s.equals("normal")) return (100 - GENERAL) / 100;
        else if(s.equals("preferential")) return (100 - TAXBREAK) / 100;
        return 1;
    }
}
