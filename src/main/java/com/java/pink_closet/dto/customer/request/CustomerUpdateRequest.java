package com.java.pink_closet.dto.customer.request;

import lombok.Data;

@Data
public class CustomerUpdateRequest {
    private String name;
    private String email;
    private String phone;
    private String password;
}