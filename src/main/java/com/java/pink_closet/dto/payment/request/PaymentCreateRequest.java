package com.java.pink_closet.dto.payment.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentCreateRequest {
    @NotNull
    private Long orderId;

    @NotBlank
    private String method;

    @NotNull
    private Double amount;
}