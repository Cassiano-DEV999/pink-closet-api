package com.java.pink_closet.dto.payment.response;

import lombok.Data;

@Data
public class PaymentResponse {
    private Long id;
    private String method;
    private String status;
}