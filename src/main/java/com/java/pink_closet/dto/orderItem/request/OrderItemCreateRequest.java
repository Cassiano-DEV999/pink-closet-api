package com.java.pink_closet.dto.orderItem.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderItemCreateRequest {
    @NotNull
    private Long orderId;

    @NotNull
    private Long productId;

    @Min(1)
    private Integer quantity;
}