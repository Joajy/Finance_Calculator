package com.finance.calculator.service;

import com.finance.calculator.entity.Deposit;
import com.finance.calculator.entity.Saving;
import org.springframework.stereotype.Service;

@Service
public class SavingService {

    public double calculateSaving(Saving saving) {
        double principal = saving.getAmount();
        double rate = saving.getInterestRate() / 100;
        int term = saving.getTerm();
        return principal * Math.pow(1 + rate, term);
    }
}
