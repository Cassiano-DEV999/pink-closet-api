package com.java.pink_closet.dto.order.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderCreateRequest {
    @NotNull
    private Long customerId;

    @NotNull
    private Long paymentId;

    @NotNull
    private Long addressId;
}