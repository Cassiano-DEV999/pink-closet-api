package com.java.pink_closet.execeptions.payment;

public class PaymentDuplicateException extends RuntimeException {
    public PaymentDuplicateException(Long orderId) {
        super("Payment already exists for order with id: " + orderId);
    }
}