package com.java.pink_closet.execeptions.returns;

public class ReturnExpiredException extends RuntimeException {
    public ReturnExpiredException(Long id) {
        super("Return with id " + id + " has expired and cannot be processed.");
    }
}
