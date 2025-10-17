package com.java.pink_closet.dto.order.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderResponse {
    private Long id;
    private String status;
    private BigDecimal total;
}