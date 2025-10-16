package com.java.pink_closet.execeptions.returns;

public class ReturnUnauthorizedException extends RuntimeException {
    public ReturnUnauthorizedException(Long id) {
        super("You are not authorized to access return with id: " + id);
    }
}