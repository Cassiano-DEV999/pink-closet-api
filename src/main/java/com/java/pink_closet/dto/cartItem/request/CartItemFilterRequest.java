package com.java.pink_closet.dto.cartItem.request;

import lombok.Data;

@Data
public class CartItemFilterRequest {
    private Long cartId;
    private Long productId;
}