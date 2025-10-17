package com.java.pink_closet.dto.refund.response;

import lombok.Data;

@Data
public class RefundDetailedResponse {
    private Long id;
    private Long orderId;
    private Long orderItemId;
    private String reason;
    private String status;
    private String observation;
}