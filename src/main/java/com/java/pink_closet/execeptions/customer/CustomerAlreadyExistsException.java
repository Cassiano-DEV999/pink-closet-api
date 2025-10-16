package com.java.pink_closet.execeptions.customer;

public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException(String email) {
        super("Customer already exists with email: " + email);
    }
}