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
        double principal = deposit.getAmount();
        double rate = deposit.getInterestRate() / 100;
        int year = deposit.getTerm();
        String interestType = deposit.getInterestType();
        long total = (long) (principal
                * appliedInterest(interestType, rate, year)
        );
        return format.format(total);
    }

    public String calculateAfterDeposit(Deposit deposit) {
        double principal = deposit.getAmount();
        double rate = deposit.getInterestRate() / 100;
        int year = deposit.getTerm();
        String interestType = deposit.getInterestType();
        String interestIncome = deposit.getInterestIncome();
        long total = (long) (principal
                * appliedInterest(interestType, rate, year)
                * type(interestIncome)
        );
        return format.format(total);
    }

}
