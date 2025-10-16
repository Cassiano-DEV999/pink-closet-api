package com.java.pink_closet.repositories.impl;

import com.java.pink_closet.model.Cart;
import com.java.pink_closet.repositories.CartRepository;
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
public class CartRepositoryImpl implements CartRepository {

    private final EntityManager em;

    @Override
    public Cart save(Cart cart) {
        if (cart.getId() == null) {
            em.persist(cart);
            return cart;
        } else {
            return em.merge(cart);
        }
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return Optional.ofNullable(em.find(Cart.class, id));
    }

    @Override
    public List<Cart> findAll() {
        return em.createQuery("SELECT c FROM Cart c", Cart.class)
                .getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Cart cart = em.find(Cart.class, id);
        if (cart != null) em.remove(cart);
    }

    @Override
    public Optional<Cart> findActiveCartByCustomerId(Long customerId) {
        TypedQuery<Cart> query = em.createQuery(
                "SELECT c FROM Cart c WHERE c.customer.id = :customerId AND c.active = true", Cart.class);
        query.setParameter("customerId", customerId);
        return query.getResultStream().findFirst();
    }

    @Override
    public List<Cart> findByCustomerId(Long customerId) {
        TypedQuery<Cart> query = em.createQuery(
                "SELECT c FROM Cart c WHERE c.customer.id = :customerId", Cart.class);
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }

    @Override
    public void deleteActiveCartByCustomerId(Long customerId) {
        em.createQuery("DELETE FROM Cart c WHERE c.customer.id = :customerId AND c.active = true")
                .setParameter("customerId", customerId)
                .executeUpdate();
    }
}
