package com.java.pink_closet.execeptions.manager;

public class ManagerAlreadyExistsException extends RuntimeException {
    public ManagerAlreadyExistsException(String email) {
        super("Manager already exists with email: " + email);
    }
}