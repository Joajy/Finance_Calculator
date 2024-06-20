package com.finance.calculator.controller;

import com.finance.calculator.entity.ExchangeRate;
import com.finance.calculator.service.ExchangeRateServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/exchange")
public class ExchangeRateController {

    private final ExchangeRateServiceImpl exchangeRateServiceImpl;

    public ExchangeRateController(ExchangeRateServiceImpl exchangeRateServiceImpl) {
        this.exchangeRateServiceImpl = exchangeRateServiceImpl;
    }

    @PostMapping("/getExchangeRate")
    public ResponseEntity<?> getExchangeRate(@RequestBody ExchangeRate exchangeRate){
        Double exchangeRateDto = exchangeRateServiceImpl.getExchangeRate(exchangeRate);
        return ResponseEntity.status(HttpStatus.OK).body(exchangeRateDto);
    }
}
