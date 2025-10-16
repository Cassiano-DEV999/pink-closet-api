package com.java.pink_closet.execeptions.payment;

public class PaymentFailedException extends RuntimeException {
    public PaymentFailedException(String message) {
        super("Payment failed: " + message);
    }
}