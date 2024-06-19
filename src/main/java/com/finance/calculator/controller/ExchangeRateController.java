package com.finance.calculator.controller;

import com.finance.calculator.service.ExchangeRateServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/exchange")
public class ExchangeRateController {

    private final ExchangeRateServiceImpl exchangeRateServiceImpl;

    public ExchangeRateController(ExchangeRateServiceImpl exchangeRateServiceImpl) {
        this.exchangeRateServiceImpl = exchangeRateServiceImpl;
    }

    @GetMapping("/getExchangeRate")
    public ResponseEntity<?> getExchangeRate(@RequestParam String country){
        BigDecimal exchangeRateDto = exchangeRateServiceImpl.getExchangeRate(country);
        System.out.println("test money: " + exchangeRateDto.toString());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        return new ResponseEntity<>(exchangeRateDto, httpHeaders, HttpStatus.OK);
    }
}
