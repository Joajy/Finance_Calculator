package com.finance.calculator.controller;

import com.finance.calculator.entity.Deposit;
import com.finance.calculator.service.DepositService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/deposit")
public class DepositController {

    private final DepositService depositService;

    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }
//
//    @GetMapping("/calculateDeposit")
//    public String showForm(Model model) {
//        model.addAttribute("deposit", new Deposit());
//        return "calculateDeposit";
//    }
//
//    @PostMapping("/calculateDeposit")
//    public String calculateDeposit(@ModelAttribute Deposit deposit, Model model) {
//        double result = depositService.calculateDeposit(deposit);
//        model.addAttribute("result", result);
//        return "result";
//    }

    @PostMapping("/calculateDeposit")
    public double calculateDeposit(@RequestBody Deposit deposit) {
        return depositService.calculateDeposit(deposit);
    }
}
