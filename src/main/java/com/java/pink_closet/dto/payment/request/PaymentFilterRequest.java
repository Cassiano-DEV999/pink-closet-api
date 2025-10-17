package com.java.pink_closet.dto.payment.request;

import lombok.Data;

@Data
public class PaymentFilterRequest {
    private String method;
    private String status;
}