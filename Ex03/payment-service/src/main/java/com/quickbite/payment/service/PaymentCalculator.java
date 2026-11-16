package com.quickbite.payment.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;

@Service
public class PaymentCalculator {

    private static final BigDecimal FEE_RATE = new BigDecimal("0.02");

    public BigDecimal calculateTotalWithFee(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero");
        }
        BigDecimal fee = amount.multiply(FEE_RATE).setScale(2, RoundingMode.HALF_UP);
        return amount.add(fee).setScale(2, RoundingMode.HALF_UP);
    }
}
