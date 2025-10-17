package com.java.pink_closet.dto.cartItem.response;

import lombok.Data;

@Data
public class CartItemDetailedResponse {
    private Long id;
    private Long cartId;
    private Long productId;
    private String productName;
    private Double productPrice;
    private Integer quantity;
}