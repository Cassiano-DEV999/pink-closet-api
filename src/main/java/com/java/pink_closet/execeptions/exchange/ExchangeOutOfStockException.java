package com.java.pink_closet.execeptions.exchange;

public class ExchangeOutOfStockException extends RuntimeException {
    public ExchangeOutOfStockException(Long productId) {
        super("Product with id " + productId + " is out of stock for exchange.");
    }
}