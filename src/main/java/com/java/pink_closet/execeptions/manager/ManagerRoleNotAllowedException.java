package com.java.pink_closet.execeptions.manager;

public class ManagerRoleNotAllowedException extends RuntimeException {
    public ManagerRoleNotAllowedException(String role) {
        super("Action not allowed for role: " + role);
    }
}