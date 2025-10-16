package com.java.pink_closet.execeptions.cart;

public class CartUnauthorizedException extends RuntimeException {
    public CartUnauthorizedException(Long id) {
        super("Cart with id " + id + " does not belong to this customer.");
    }
}
