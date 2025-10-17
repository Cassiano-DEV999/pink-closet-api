package com.java.pink_closet.dto.orderItem.request;

import lombok.Data;

@Data
public class OrderItemFilterRequest {
    private Long orderId;
    private Long productId;
}
