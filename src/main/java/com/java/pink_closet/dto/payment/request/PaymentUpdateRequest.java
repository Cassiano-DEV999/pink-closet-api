package com.java.pink_closet.dto.payment.request;

import lombok.Data;

@Data
public class PaymentUpdateRequest {
    private String status;
    private String transactionCode;
}