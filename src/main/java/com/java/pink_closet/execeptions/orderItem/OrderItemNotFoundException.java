package com.java.pink_closet.execeptions.orderItem;

public class OrderItemNotFoundException extends RuntimeException {
    public OrderItemNotFoundException(Long id) {
        super("OrderItem not found with id: " + id);
    }
}