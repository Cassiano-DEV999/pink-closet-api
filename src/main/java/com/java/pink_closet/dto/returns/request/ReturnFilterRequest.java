package com.java.pink_closet.dto.returns.request;

import lombok.Data;

@Data
public class ReturnFilterRequest {
    private Long orderId;
    private String status;
}