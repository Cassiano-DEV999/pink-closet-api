package com.java.pink_closet.dto.cart.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CartCreateRequest {
    @NotNull
    private Long customerId;
}