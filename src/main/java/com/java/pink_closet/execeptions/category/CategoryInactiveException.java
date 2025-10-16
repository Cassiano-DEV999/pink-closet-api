package com.java.pink_closet.execeptions.category;

public class CategoryInactiveException extends RuntimeException {
    public CategoryInactiveException(Long id) {
        super("Category with id " + id + " is inactive.");
    }
}