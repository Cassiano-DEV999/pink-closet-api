package com.java.pink_closet.execeptions.exchange;

public class ExchangeInvalidStatusException extends RuntimeException {
    public ExchangeInvalidStatusException(String status) {
        super("Exchange status is invalid: " + status);
    }
}