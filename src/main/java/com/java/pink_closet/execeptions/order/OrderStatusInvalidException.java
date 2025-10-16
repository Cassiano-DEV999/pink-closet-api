package com.java.pink_closet.execeptions.order;

public class OrderStatusInvalidException extends RuntimeException {
    public OrderStatusInvalidException(String status) {
        super("Invalid order status: " + status);
    }
}
