package com.finance.calculator.service;

import java.math.BigDecimal;

public interface ExchangeRateService {
    BigDecimal getExchangeRate(String country);
}
