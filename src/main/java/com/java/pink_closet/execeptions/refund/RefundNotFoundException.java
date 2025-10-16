package com.java.pink_closet.execeptions.refund;

public class RefundNotFoundException extends RuntimeException {
    public RefundNotFoundException(Long id) {
        super("Refund not found with id: " + id);
    }
}