package com.java.pink_closet.dto.exchange.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ExchangeCreateRequest {
    @NotNull
    private Long orderId;

    @NotNull
    private Long orderItemId;

    @NotBlank
    private String reason;
}