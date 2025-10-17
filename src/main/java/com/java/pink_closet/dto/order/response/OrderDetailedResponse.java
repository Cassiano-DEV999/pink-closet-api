package com.java.pink_closet.dto.order.response;

import com.java.pink_closet.dto.orderItem.response.OrderItemResponse;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDetailedResponse {
    private Long id;
    private String status;
    private Double total;
    private LocalDateTime createdAt;

    private Long customerId;
    private String customerName;

    private Long paymentId;
    private String paymentStatus;

    private Long addressId;
    private String deliveryCity;

    private List<OrderItemResponse> items;
}