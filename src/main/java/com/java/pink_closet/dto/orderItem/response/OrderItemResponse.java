package com.java.pink_closet.dto.orderItem.response;

import lombok.Data;

@Data
public class OrderItemResponse {
    private Long id;
    private Long productId;
    private Integer quantity;
}