package com.java.pink_closet.dto.product.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductCreateRequest {
    @NotBlank
    private String name;

    private String description;

    @NotNull
    private Long categoryId;

    @NotNull
    @Min(0)
    private Double price;

    @Min(0)
    private Integer stockQuantity;

    @Data
    public static class ProductFilterRequest {
        private String name;
        private Long categoryId;
        private Double minPrice;
        private Double maxPrice;
    }
}