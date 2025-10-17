package com.java.pink_closet.dto.exchange.response;

import lombok.Data;

@Data
public class ExchangeDetailedResponse {
    private Long id;
    private Long orderId;
    private Long orderItemId;
    private String reason;
    private String status;
    private String observation;
}