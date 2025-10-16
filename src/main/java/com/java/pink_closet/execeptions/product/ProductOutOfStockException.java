package com.java.pink_closet.execeptions.product;

public class ProductOutOfStockException extends RuntimeException {
    public ProductOutOfStockException(Long id, int requested, int available) {
        super("Product with id " + id + " has only " + available + " units, requested: " + requested);
    }
}
