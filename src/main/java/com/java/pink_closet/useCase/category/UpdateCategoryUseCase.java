package com.java.pink_closet.useCase.category;

import com.java.pink_closet.dto.category.request.CategoryUpdateRequest;
import com.java.pink_closet.dto.category.response.CategoryResponse;
import com.java.pink_closet.execeptions.category.CategoryNotFoundException;
import com.java.pink_closet.mapper.CategoryMapper;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.CategoryRepository;

@Service
public class UpdateCategoryUseCase {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public UpdateCategoryUseCase(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryResponse execute(Long id, CategoryUpdateRequest request) {
        var category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
        categoryMapper.toEntity(request);
        category = categoryRepository.save(category);
        return categoryMapper.toResponse(category);
    }
}
