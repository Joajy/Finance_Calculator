package com.finance.calculator.controller;

import com.finance.calculator.entity.Deposit;
import com.finance.calculator.service.DepositService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deposit")
public class DepositController {

    private final DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @PostMapping("/calculate/before")
    public ResponseEntity<String> calculateBeforeDeposit(@RequestBody Deposit deposit) {
        String money = depositService.calculateBeforeDeposit(deposit);
        return ResponseEntity.status(HttpStatus.OK).body(money);
    }

    @PostMapping("/calculate/after")
    public ResponseEntity<String> calculateAfterDeposit(@RequestBody Deposit deposit) {
        String money = depositService.calculateAfterDeposit(deposit);
        return ResponseEntity.status(HttpStatus.OK).body(money);
    }
}
