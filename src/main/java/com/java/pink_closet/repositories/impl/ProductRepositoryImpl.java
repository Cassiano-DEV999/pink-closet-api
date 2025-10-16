package com.java.pink_closet.repositories.impl;

import com.java.pink_closet.execeptions.product.ProductNotFoundException;
import com.java.pink_closet.model.Product;
import com.java.pink_closet.repositories.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    private final EntityManager em;


    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            em.persist(product);
            return product;
        } else {
            return em.merge(product);
        }
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(em.find(Product.class, id));
    }

    @Override
    public void deleteById(Long id) {
        Product product = em.find(Product.class, id);
        if (product != null) em.remove(product);
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }


    @Override
    public List<Product> findByCategoryId(Long categoryId) {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE p.category.id = :categoryId", Product.class);
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    @Override
    public List<Product> findByNameContaining(String name) {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))", Product.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Product> findByStatus(String status) {
        boolean isActive = "ACTIVE".equalsIgnoreCase(status);
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE p.active = :isActive", Product.class);
        query.setParameter("isActive", isActive);
        return query.getResultList();
    }

    @Override
    public List<Product> findByPriceRange(Double min, Double max) {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max", Product.class);
        query.setParameter("min", min);
        query.setParameter("max", max);
        return query.getResultList();
    }

    @Override
    public void addImages(Long productId, List<String> imageUrls) {
        Product product = em.find(Product.class, productId);
        if (product != null) {
            if (product.getImageUrls() == null) {
                product.setImageUrls(new ArrayList<>());
            }
            product.getImageUrls().addAll(imageUrls);
            em.merge(product);
        } else {
            throw new ProductNotFoundException(productId);
        }
    }

    @Override
    public void removeImage(Long productId, String imageUrl) {
        Product product = em.find(Product.class, productId);
        if (product != null && product.getImageUrls() != null) {
            product.getImageUrls().removeIf(img -> img.equals(imageUrl));
            em.merge(product);
        } else {
            throw new ProductNotFoundException(productId);
        }
    }
}
