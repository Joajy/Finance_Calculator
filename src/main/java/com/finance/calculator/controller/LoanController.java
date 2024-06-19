package com.finance.calculator.controller;

import com.finance.calculator.entity.Loan;
import com.finance.calculator.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<String> calculateLoan(@RequestBody Loan loan) {
        String money = loanService.calculateLoan(loan);
        return ResponseEntity.status(HttpStatus.OK).body(money);
    }
}
