package com.java.pink_closet.repositories.impl;

import com.java.pink_closet.model.Order;
import com.java.pink_closet.repositories.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional
public class OrderRepositoryImpl implements OrderRepository {

    private final EntityManager em;


    @Override
    public Order save(Order order) {
        if (order.getId() == null) {
            em.persist(order);
            return order;
        } else {
            return em.merge(order);
        }
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(em.find(Order.class, id));
    }

    @Override
    public List<Order> findAll() {
        return em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Order order = em.find(Order.class, id);
        if (order != null) em.remove(order);
    }

    @Override
    public List<Order> findByCustomerId(Long customerId) {
        TypedQuery<Order> query = em.createQuery(
                "SELECT o FROM Order o WHERE o.customer.id = :customerId", Order.class);
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }

    @Override
    public List<Order> findByCustomerIdAndStatus(Long customerId, String status) {
        TypedQuery<Order> query = em.createQuery(
                "SELECT o FROM Order o WHERE o.customer.id = :customerId AND o.status = :status", Order.class);
        query.setParameter("customerId", customerId);
        query.setParameter("status", status);
        return query.getResultList();
    }

    @Override
    public List<Order> findByCustomerIdAndDateRange(Long customerId, LocalDateTime start, LocalDateTime end) {
        TypedQuery<Order> query = em.createQuery(
                "SELECT o FROM Order o WHERE o.customer.id = :customerId AND o.orderDate BETWEEN :start AND :end", Order.class);
        query.setParameter("customerId", customerId);
        query.setParameter("start", start);
        query.setParameter("end", end);
        return query.getResultList();
    }
}
