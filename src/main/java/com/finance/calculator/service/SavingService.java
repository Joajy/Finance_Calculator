package com.finance.calculator.service;

import com.finance.calculator.entity.Saving;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

import static com.finance.calculator.constant.InterestIncome.type;
import static com.finance.calculator.constant.InterestType.savingAppliedInterest;

@Service
public class SavingService {

    private static final DecimalFormat format = new DecimalFormat("###,###");

    public String calculateBeforeSaving(Saving saving) {
        double principal = saving.getAmount();
        double rate = saving.getInterestRate() / 100;
        int year = saving.getYear();
        String interestType = saving.getInterestType();
        long total = (long) (principal
                * savingAppliedInterest(interestType, rate, year)
        );
        return format.format(total);
    }

    public String calculateAfterSaving(Saving saving) {
        double principal = saving.getAmount();
        double rate = saving.getInterestRate() / 100;
        int year = saving.getYear();
        String interestIncome = saving.getInterestIncome();
        String interestType = saving.getInterestType();
        long interest = (long)(principal * savingAppliedInterest(interestType, rate, year) - principal);
        long total = (long) (
                principal + interest * type(interestIncome)
        );
        return format.format(total);
    }
}
