package com.java.pink_closet.execeptions.category;

public class CategoryAlreadyExistsException extends RuntimeException {
    public CategoryAlreadyExistsException(String name) {
        super("Category already exists with name: " + name);
    }
}