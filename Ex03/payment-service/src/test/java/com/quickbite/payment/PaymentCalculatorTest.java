package com.quickbite.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.quickbite.payment.service.PaymentCalculator;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class PaymentCalculatorTest {

    private final PaymentCalculator calculator = new PaymentCalculator();

    @Test
    void shouldCalculateTotalWithTwoPercentFee() {
        BigDecimal total = calculator.calculateTotalWithFee(new BigDecimal("100.00"));
        assertEquals(new BigDecimal("102.00"), total);
    }

    @Test
    void shouldRejectNonPositiveAmount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.calculateTotalWithFee(BigDecimal.ZERO));
    }
}
