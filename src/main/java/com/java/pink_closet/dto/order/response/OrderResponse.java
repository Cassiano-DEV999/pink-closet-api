package com.java.pink_closet.dto.order.response;

import lombok.Data;

@Data
public class OrderResponse {
    private Long id;
    private String status;
    private Double total;
}