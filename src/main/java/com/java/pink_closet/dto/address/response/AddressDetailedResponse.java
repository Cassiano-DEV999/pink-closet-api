package com.java.pink_closet.dto.address.response;

import lombok.Data;

@Data
public class AddressDetailedResponse {
    private Long id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
    private Long customerId;
    private String customerName;
}