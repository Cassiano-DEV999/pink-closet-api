package com.java.pink_closet.execeptions.customer;

public class CustomerInactiveException extends RuntimeException {
    public CustomerInactiveException(Long id) {
        super("Customer with id " + id + " is inactive and cannot perform this action.");
    }
}