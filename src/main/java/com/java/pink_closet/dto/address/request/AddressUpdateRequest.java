package com.java.pink_closet.dto.address.request;

import lombok.Data;

@Data
public class AddressUpdateRequest {
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
}