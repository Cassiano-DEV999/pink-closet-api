package com.java.pink_closet.dto.cart.response;

import lombok.Data;
import java.util.List;

@Data
public class CartDetailedResponse {
    private Long id;
    private Long customerId;
    private String customerName;
    private Boolean active;
    private List<CartItemResponse> items;
}