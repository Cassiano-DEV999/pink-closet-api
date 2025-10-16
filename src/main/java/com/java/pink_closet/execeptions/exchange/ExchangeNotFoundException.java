package com.java.pink_closet.execeptions.exchange;

public class ExchangeNotFoundException extends RuntimeException {
    public ExchangeNotFoundException(Long id) {
        super("Exchange not found with id: " + id);
    }
}
