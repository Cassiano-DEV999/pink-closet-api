package com.java.pink_closet.dto.cart.response;

import lombok.Data;

@Data
public class CartResponse {
    private Long id;
    private Long customerId;
    private Boolean active;
}