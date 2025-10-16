package com.java.pink_closet.execeptions.manager;

public class ManagerInactiveException extends RuntimeException {
    public ManagerInactiveException(Long id) {
        super("Manager with id " + id + " is inactive.");
    }
}