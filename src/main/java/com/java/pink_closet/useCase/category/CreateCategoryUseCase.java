package com.java.pink_closet.useCase.category;

import com.java.pink_closet.dto.category.request.CategoryCreateRequest;
import com.java.pink_closet.dto.category.response.CategoryResponse;
import com.java.pink_closet.mapper.CategoryMapper;
import com.java.pink_closet.model.Category;
import com.java.pink_closet.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryUseCase {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CreateCategoryUseCase(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryResponse execute(CategoryCreateRequest request) {
        Category category = categoryMapper.toEntity(request);
        category = categoryRepository.save(category);
        return categoryMapper.toResponse(category);
    }
}
