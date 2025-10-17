package com.java.pink_closet.dto.orderItem.request;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class OrderItemUpdateRequest {
    @Min(1)
    private Integer quantity;
}