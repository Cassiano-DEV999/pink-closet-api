package com.java.pink_closet.execeptions.orderItem;

public class OrderItemUnauthorizedException extends RuntimeException {
    public OrderItemUnauthorizedException(Long id) {
        super("You are not authorized to access order item with id: " + id);
    }
}