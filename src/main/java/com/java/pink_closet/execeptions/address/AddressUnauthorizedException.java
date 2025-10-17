    package com.java.pink_closet.execeptions.address;

    public class AddressUnauthorizedException extends RuntimeException {
        public AddressUnauthorizedException(Long id) {
            super("Address with id " + id + " does not belong to this customer.");
        }
    }
