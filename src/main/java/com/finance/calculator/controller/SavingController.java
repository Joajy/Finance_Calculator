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

    @PostMapping("/calculate/before")
    public ResponseEntity<String> calculateBeforeSaving(@RequestBody Saving saving) {
        String money = savingService.calculateBeforeSaving(saving);
        return ResponseEntity.status(HttpStatus.OK).body(money);
    }

    @PostMapping("/calculate/after")
    public ResponseEntity<String> calculateAfterSaving(@RequestBody Saving saving) {
        String money = savingService.calculateAfterSaving(saving);
        return ResponseEntity.status(HttpStatus.OK).body(money);
    }
}
