package com.java.pink_closet.dto.cartItem.request;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class CartItemUpdateRequest {
    @Min(1)
    private Integer quantity;
}