package com.java.pink_closet.dto.exchange.request;

import lombok.Data;

@Data
public class ExchangeFilterRequest {
    private Long orderId;
    private String status;
}