package com.java.pink_closet.execeptions.product;

public class ProductInactiveException extends RuntimeException {
    public ProductInactiveException(Long id) {
        super("Product with id " + id + " is inactive or discontinued.");
    }
}