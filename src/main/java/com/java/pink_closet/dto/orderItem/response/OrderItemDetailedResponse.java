package com.java.pink_closet.dto.orderItem.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDetailedResponse {
    private Long id;
    private Long orderId;
    private Long productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer quantity;
}