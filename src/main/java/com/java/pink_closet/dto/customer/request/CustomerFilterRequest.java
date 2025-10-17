package com.java.pink_closet.dto.customer.request;

import lombok.Data;

@Data
public class CustomerFilterRequest {
    private String name;
    private String email;
}