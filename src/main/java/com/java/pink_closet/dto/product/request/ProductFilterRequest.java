package com.java.pink_closet.dto.product.request;

import lombok.Data;

@Data
public class ProductFilterRequest {
    private String name;
    private Long categoryId;
    private Double minPrice;
    private Double maxPrice;
}