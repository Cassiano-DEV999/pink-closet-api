package com.java.pink_closet.dto.product.request;

import lombok.Data;

@Data
public class ProductUpdateRequest {
    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;
    private Long categoryId;
}