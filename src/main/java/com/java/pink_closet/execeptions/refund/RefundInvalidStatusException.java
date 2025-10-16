package com.java.pink_closet.execeptions.refund;

public class RefundInvalidStatusException extends RuntimeException {
    public RefundInvalidStatusException(String status) {
        super("Invalid refund status: " + status);
    }
}