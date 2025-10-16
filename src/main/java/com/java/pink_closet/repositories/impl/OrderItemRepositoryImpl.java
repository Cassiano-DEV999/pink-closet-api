package com.java.pink_closet.repositories.impl;

import com.java.pink_closet.model.OrderItem;
import com.java.pink_closet.repositories.OrderItemRepository;
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
public class OrderItemRepositoryImpl implements OrderItemRepository {

    private final EntityManager em;

    @Override
    public OrderItem save(OrderItem item) {
        if (item.getId() == null) {
            em.persist(item);
            return item;
        } else {
            return em.merge(item);
        }
    }

    @Override
    public Optional<OrderItem> findById(Long id) {
        return Optional.ofNullable(em.find(OrderItem.class, id));
    }

    @Override
    public void deleteById(Long id) {
        OrderItem item = em.find(OrderItem.class, id);
        if (item != null) em.remove(item);
    }

    @Override
    public List<OrderItem> findByOrderId(Long orderId) {
        TypedQuery<OrderItem> query = em.createQuery(
                "SELECT oi FROM OrderItem oi WHERE oi.order.id = :orderId", OrderItem.class);
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }
}
