package com.java.pink_closet.dto.order.request;

import lombok.Data;

@Data
public class OrderFilterRequest {
    private Long customerId;
    private String status;
}