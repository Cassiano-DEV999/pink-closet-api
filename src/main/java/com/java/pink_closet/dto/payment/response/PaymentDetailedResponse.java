package com.java.pink_closet.dto.payment.response;

import lombok.Data;

@Data
public class PaymentDetailedResponse {
    private Long id;
    private String method;
    private Double amount;
    private String status;
    private String transactionCode;
    private Long orderId;
}
