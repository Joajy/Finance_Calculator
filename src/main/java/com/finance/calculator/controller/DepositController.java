package com.finance.calculator.controller;

import com.finance.calculator.entity.Deposit;
import com.finance.calculator.service.DepositService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/deposit")
public class DepositController {

    private final DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @GetMapping
    public String deposit(){
        return "deposit";
    }

    @PostMapping("/calculate")
    public ResponseEntity<Double> calculateDeposit(@RequestBody Deposit deposit) {
        double money = depositService.calculateDeposit(deposit);
        return ResponseEntity.status(HttpStatus.OK).body(money);
    }
}
