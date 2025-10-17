package com.java.pink_closet.dto.category.request;

import lombok.Data;

@Data
public class CategoryUpdateRequest {
    private String name;
    private String description;
}