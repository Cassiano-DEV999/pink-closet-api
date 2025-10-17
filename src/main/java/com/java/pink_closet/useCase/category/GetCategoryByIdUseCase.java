package com.java.pink_closet.useCase.category;

import com.java.pink_closet.dto.category.response.CategoryResponse;
import com.java.pink_closet.execeptions.category.CategoryNotFoundException;
import com.java.pink_closet.mapper.CategoryMapper;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.CategoryRepository;

@Service
public class GetCategoryByIdUseCase {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public GetCategoryByIdUseCase(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryResponse execute(Long id) {
        var category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
        return categoryMapper.toResponse(category);
    }
}
