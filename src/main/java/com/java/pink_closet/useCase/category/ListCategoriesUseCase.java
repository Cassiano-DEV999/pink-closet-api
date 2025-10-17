package com.java.pink_closet.useCase.category;

import com.java.pink_closet.dto.category.response.CategoryResponse;
import com.java.pink_closet.mapper.CategoryMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import com.java.pink_closet.repositories.CategoryRepository;

@Service
public class ListCategoriesUseCase {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public ListCategoriesUseCase(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryResponse> execute() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }
}
