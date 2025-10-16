package com.java.pink_closet.execeptions.cart;

public class CartItemAlreadyExistsException extends RuntimeException {
    public CartItemAlreadyExistsException(Long productId) {
        super("Product with id " + productId + " is already in the cart.");
    }
}