package com.java.pink_closet.dto.cartItem.response;

import lombok.Data;

@Data
public class CartItemResponse {
    private Long id;
    private Long productId;
    private Integer quantity;
}