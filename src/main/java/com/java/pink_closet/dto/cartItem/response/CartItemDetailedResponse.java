package com.java.pink_closet.dto.cartItem.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDetailedResponse {
    private Long id;
    private Long cartId;
    private Long productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer quantity;
}