package com.java.pink_closet.dto.returns.response;

import lombok.Data;

@Data
public class ReturnDetailedResponse {
    private Long id;
    private Long orderId;
    private Long orderItemId;
    private String reason;
    private String status;
    private String observation;
}