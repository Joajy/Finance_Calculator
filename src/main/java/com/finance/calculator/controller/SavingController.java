package com.finance.calculator.controller;

import com.finance.calculator.entity.Saving;
import com.finance.calculator.service.SavingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/saving")
public class SavingController {

    private final SavingService savingService;

    public SavingController(SavingService savingService) {
        this.savingService = savingService;
    }

    @GetMapping
    public String saving(){
        return "saving";
    }

    @PostMapping("/beforeCalculate")
    public ResponseEntity<Double> calculateBeforeSaving(@RequestBody Saving saving) {
        double money = savingService.calculateBeforeSaving(saving);
        return ResponseEntity.status(HttpStatus.OK).body(money);
    }

    @PostMapping("/afterCalculate")
    public ResponseEntity<Double> calculateAfterSaving(@RequestBody Saving saving) {
        double money = savingService.calculateAfterSaving(saving);
        return ResponseEntity.status(HttpStatus.OK).body(money);
    }
}
