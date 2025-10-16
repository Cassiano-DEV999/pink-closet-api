package com.java.pink_closet.execeptions.refund;

public class RefundValidationException extends RuntimeException {
    public RefundValidationException(String message) {
        super(message);
    }
}