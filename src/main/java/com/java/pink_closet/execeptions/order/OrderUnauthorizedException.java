package com.java.pink_closet.execeptions.order;

public class OrderUnauthorizedException extends RuntimeException {
    public OrderUnauthorizedException(Long id) {
        super("You are not authorized to access order with id: " + id);
    }
}