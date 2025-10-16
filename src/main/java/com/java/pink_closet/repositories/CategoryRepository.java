package com.java.pink_closet.repositories;

import com.java.pink_closet.model.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Category save(Category category);

    Optional<Category> findById(Long id);
    Optional<Category> findActiveById(Long id); // nova query ativa
    Optional<Category> findByName(String name);

    List<Category> findAll();
    List<Category> findAllActive(); // nova lista apenas ativas
    void deleteById(Long id);
}
