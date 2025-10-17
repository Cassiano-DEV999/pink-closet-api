package com.java.pink_closet.dto.cartItem.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CartItemCreateRequest {
    @NotNull
    private Long cartId;

    @NotNull
    private Long productId;

    @Min(1)
    private Integer quantity;
}