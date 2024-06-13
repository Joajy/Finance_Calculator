package com.finance.calculator.service;

import com.finance.calculator.entity.Deposit;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

import static com.finance.calculator.constant.InterestIncome.*;
import static com.finance.calculator.constant.InterestType.*;

@Service
public class DepositService {

    private static final DecimalFormat format = new DecimalFormat("###,###");

    public String calculateBeforeDeposit(Deposit deposit) {
        int year = deposit.getYear();
        double rate = deposit.getInterestRate() / 100;
        String interestType = deposit.getInterestType();
        long total = (long) (deposit.getAmount() * depositAppliedInterest(interestType, rate, year));
        return format.format(total);
    }

    public String calculateAfterDeposit(Deposit deposit) {
        int year = deposit.getYear();
        double principal = deposit.getAmount(year);
        double rate = deposit.getInterestRate() / 100;
        String interestIncome = deposit.getInterestIncome();
        String interestType = deposit.getInterestType();
        double interest = deposit.getAmount() * depositAppliedInterest(interestType, rate, year) - principal;
        long total = (long) (principal + interest * type(interestIncome));
        return format.format(total);
    }

}
