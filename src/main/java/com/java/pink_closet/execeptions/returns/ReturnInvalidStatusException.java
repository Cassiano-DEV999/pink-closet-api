package com.java.pink_closet.execeptions.returns;

public class ReturnInvalidStatusException extends RuntimeException {
    public ReturnInvalidStatusException(String status) {
        super("Invalid return status: " + status);
    }
}

