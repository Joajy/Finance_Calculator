package com.finance.calculator.service;

import com.finance.calculator.entity.Loan;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

import static com.finance.calculator.constant.LoanType.*;

@Service
public class LoanService {

    private static final DecimalFormat format = new DecimalFormat("###,###");

    public String calculateLoan(Loan loan) {
        double principal = loan.getAmount();
        double rate = loan.getInterestRate() / 100;
        int year = loan.getYear();
        String loanType = loan.getLoanType();
        long total = (long) (principal + principal
                * selectLoanType(loanType, rate, year)
//                * appliedInterest(interestType, rate, year)
        );
        return format.format(total);
    }
}
