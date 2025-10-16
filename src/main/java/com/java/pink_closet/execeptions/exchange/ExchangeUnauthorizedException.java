package com.java.pink_closet.execeptions.exchange;

public class ExchangeUnauthorizedException extends RuntimeException {
    public ExchangeUnauthorizedException(Long id) {
        super("You are not authorized to access exchange with id: " + id);
    }
}