package com.java.pink_closet.dto.customer.response;

import lombok.Data;

@Data
public class CustomerDetailedResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
}