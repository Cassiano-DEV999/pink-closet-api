package com.java.pink_closet.execeptions.order;

public class OrderDateInvalidException extends RuntimeException {
    public OrderDateInvalidException(String message) {
        super(message);
    }
}
