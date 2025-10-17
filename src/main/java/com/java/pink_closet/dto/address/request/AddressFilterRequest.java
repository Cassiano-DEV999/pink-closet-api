package com.java.pink_closet.dto.address.request;

import lombok.Data;

@Data
public class AddressFilterRequest {
    private String city;
    private String state;
    private String zipCode;
}