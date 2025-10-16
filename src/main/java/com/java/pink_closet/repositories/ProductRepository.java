package com.java.pink_closet.repositories;

import com.java.pink_closet.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    List<Product> findByCategoryId(Long categoryId);
    void deleteById(Long id);
    List<Product> findByNameContaining(String name);
    List<Product> findByStatus(String status);
    List<Product> findByPriceRange(Double min, Double max);
    void addImages(Long productId, List<String> imageUrls);
    void removeImage(Long productId, String imageUrl);
}