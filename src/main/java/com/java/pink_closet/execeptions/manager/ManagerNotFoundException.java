package com.java.pink_closet.execeptions.manager;

public class ManagerNotFoundException extends RuntimeException {
    public ManagerNotFoundException(Long id) {
        super("Manager not found with id: " + id);
    }

    public ManagerNotFoundException(String email) {
        super("Manager not found with email: " + email);
    }
}
