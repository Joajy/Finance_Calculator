package com.finance.calculator.service;

import com.finance.calculator.constant.InterestIncome;
import com.finance.calculator.entity.Saving;
import org.springframework.stereotype.Service;

@Service
public class SavingService {

    public double calculateBeforeSaving(Saving saving) {
        double principal = saving.getAmount();
        double rate = saving.getInterestRate() / 100;
        int term = saving.getTerm();
        return (long)(
                principal * Math.pow(1 + rate, term)
        );
    }

    public double calculateAfterSaving(Saving saving) {
        double principal = saving.getAmount();
        double rate = saving.getInterestRate() / 100;
        int term = saving.getTerm();
        String interestIncome = saving.getInterestIncome();
        return (long)(
                principal
                        * Math.pow(1 + rate, term)
                        * (InterestIncome.type(interestIncome) / 100)
        );
    }
}
