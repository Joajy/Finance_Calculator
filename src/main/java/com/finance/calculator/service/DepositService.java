package com.finance.calculator.service;

import com.finance.calculator.entity.Deposit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
public class DepositService {

    public double calculateDeposit(Deposit deposit) {
        double principal = deposit.getAmount();
        double rate = deposit.getInterestRate() / 100;
        int term = deposit.getTerm();
        return principal * Math.pow(1 + rate, term);
    }
}
