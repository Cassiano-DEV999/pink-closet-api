package com.java.pink_closet.dto.refund.request;

import lombok.Data;

@Data
public class RefundFilterRequest {
    private Long orderId;
    private String status;
}