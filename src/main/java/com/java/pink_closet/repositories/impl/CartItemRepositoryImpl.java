package com.java.pink_closet.repositories.impl;

import com.java.pink_closet.model.CartItem;
import com.java.pink_closet.repositories.CartItemRepository;
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
public class CartItemRepositoryImpl implements CartItemRepository {

    private final EntityManager em;

    @Override
    public CartItem save(CartItem cartItem) {
        // Calcula subtotal automaticamente
        if (cartItem.getProduct() != null && cartItem.getQuantity() != null) {
            cartItem.setSubtotal(cartItem.getQuantity() * cartItem.getProduct().getPrice());
        }

        if (cartItem.getId() == null) {
            em.persist(cartItem);
            return cartItem;
        } else {
            return em.merge(cartItem);
        }
    }

    @Override
    public Optional<CartItem> findById(Long id) {
        return Optional.ofNullable(em.find(CartItem.class, id));
    }

    @Override
    public void deleteById(Long id) {
        CartItem item = em.find(CartItem.class, id);
        if (item != null) em.remove(item);
    }

    @Override
    public List<CartItem> findByCartId(Long cartId) {
        TypedQuery<CartItem> query = em.createQuery(
                "SELECT ci FROM CartItem ci WHERE ci.cart.id = :cartId", CartItem.class);
        query.setParameter("cartId", cartId);
        return query.getResultList();
    }

    @Override
    public Optional<CartItem> findByCartIdAndProductId(Long cartId, Long productId) {
        TypedQuery<CartItem> query = em.createQuery(
                "SELECT ci FROM CartItem ci WHERE ci.cart.id = :cartId AND ci.product.id = :productId", CartItem.class);
        query.setParameter("cartId", cartId);
        query.setParameter("productId", productId);
        return query.getResultStream().findFirst();
    }

    @Override
    public List<CartItem> findSelectedByCartId(Long cartId) {
        TypedQuery<CartItem> query = em.createQuery(
                "SELECT ci FROM CartItem ci WHERE ci.cart.id = :cartId AND ci.selected = true", CartItem.class);
        query.setParameter("cartId", cartId);
        return query.getResultList();
    }

    @Override
    public void deleteByCartId(Long cartId) {
        em.createQuery("DELETE FROM CartItem ci WHERE ci.cart.id = :cartId")
                .setParameter("cartId", cartId)
                .executeUpdate();
    }
}
