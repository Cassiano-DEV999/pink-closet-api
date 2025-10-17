package com.java.pink_closet.useCase.category;

import com.java.pink_closet.execeptions.category.CategoryNotFoundException;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.CategoryRepository;

@Service
public class DeleteCategoryUseCase {

    private final CategoryRepository categoryRepository;

    public DeleteCategoryUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void execute(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new CategoryNotFoundException(id);
        }
        categoryRepository.deleteById(id);
    }
}
