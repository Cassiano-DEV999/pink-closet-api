package com.java.pink_closet.execeptions.payment;

public class PaymentMethodInvalidException extends RuntimeException {
    public PaymentMethodInvalidException(String method) {
        super("Invalid payment method: " + method);
    }
}