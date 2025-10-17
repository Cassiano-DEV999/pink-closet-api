package com.java.pink_closet.dto.address.response;

import lombok.Data;

@Data
public class AddressResponse {
    private Long id;
    private String street;
    private String number;
    private String city;
    private String state;
    private String zipCode;
}