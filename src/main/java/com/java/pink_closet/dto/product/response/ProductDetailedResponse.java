package com.java.pink_closet.dto.product.response;

import lombok.Data;

@Data
public class ProductDetailedResponse {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;
    private Long categoryId;
    private String categoryName;
}