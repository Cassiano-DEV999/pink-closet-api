package com.java.pink_closet.execeptions.returns;

public class ReturnNotFoundException extends RuntimeException {
    public ReturnNotFoundException(Long id) {
        super("Return not found with id: " + id);
    }
}
