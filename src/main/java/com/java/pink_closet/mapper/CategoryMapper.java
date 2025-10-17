package com.java.pink_closet.mapper;

import com.java.pink_closet.dto.category.request.CategoryCreateRequest;
import com.java.pink_closet.dto.category.request.CategoryUpdateRequest;
import com.java.pink_closet.dto.category.response.CategoryDetailedResponse;
import com.java.pink_closet.dto.category.response.CategoryResponse;
import com.java.pink_closet.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toEntity(CategoryCreateRequest request);
    Category toEntity(CategoryUpdateRequest request);

    CategoryResponse toResponse(Category entity);
    CategoryDetailedResponse toDetailedResponse(Category entity);
}