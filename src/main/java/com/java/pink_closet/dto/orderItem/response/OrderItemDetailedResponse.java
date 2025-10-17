package com.java.pink_closet.dto.orderItem.response;

import lombok.Data;

@Data
public class OrderItemDetailedResponse {
    private Long id;
    private Long orderId;
    private Long productId;
    private String productName;
    private Double productPrice;
    private Integer quantity;
}