package com.finance.calculator.controller;

import com.finance.calculator.entity.Loan;
import com.finance.calculator.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loan")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public String loan(){
        return "loan";
    }

    @PostMapping("/calculate")
    public ResponseEntity<String> calculateLoan(@RequestBody Loan loan) {
        String money = loanService.calculateLoan(loan);
        return ResponseEntity.status(HttpStatus.OK).body(money);
    }
}
