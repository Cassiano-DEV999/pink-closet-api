package com.java.pink_closet.repositories.impl;

import com.java.pink_closet.model.Category;
import com.java.pink_closet.repositories.CategoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {

    private final EntityManager em;


    @Override
    public Category save(Category category) {
        if (category.getId() == null) {
            em.persist(category);
            return category;
        } else {
            return em.merge(category);
        }
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.ofNullable(em.find(Category.class, id));
    }

    @Override
    public void deleteById(Long id) {
        Category category = em.find(Category.class, id);
        if (category != null) em.remove(category);
    }

    @Override
    public List<Category> findAll() {
        return em.createQuery("SELECT c FROM Category c", Category.class)
                .getResultList();
    }


    @Override
    public Optional<Category> findActiveById(Long id) {
        TypedQuery<Category> query = em.createQuery(
                "SELECT c FROM Category c WHERE c.id = :id AND c.active = true", Category.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst();
    }

    @Override
    public List<Category> findAllActive() {
        TypedQuery<Category> query = em.createQuery(
                "SELECT c FROM Category c WHERE c.active = true", Category.class);
        return query.getResultList();
    }

    @Override
    public Optional<Category> findByName(String name) {
        TypedQuery<Category> query = em.createQuery(
                "SELECT c FROM Category c WHERE c.name = :name", Category.class);
        query.setParameter("name", name);
        return query.getResultStream().findFirst();
    }
}
