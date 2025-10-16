package com.java.pink_closet.execeptions.orderItem;

public class OrderItemInvalidException extends RuntimeException {
    public OrderItemInvalidException(String message) {
        super(message);
    }
}