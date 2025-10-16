package com.java.pink_closet.repositories.impl;

import com.java.pink_closet.model.Exchange;
import com.java.pink_closet.model.ExchangeStatus;
import com.java.pink_closet.repositories.ExchangeRepository;
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
public class ExchangeRepositoryImpl implements ExchangeRepository {

    private final EntityManager em;

    @Override
    public Exchange save(Exchange exchange) {
        if (exchange.getId() == null) {
            em.persist(exchange);
            return exchange;
        } else {
            return em.merge(exchange);
        }
    }

    @Override
    public Optional<Exchange> findById(Long id) {
        return Optional.ofNullable(em.find(Exchange.class, id));
    }

    @Override
    public List<Exchange> findAll() {
        return em.createQuery("SELECT e FROM Exchange e", Exchange.class)
                .getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Exchange exchange = em.find(Exchange.class, id);
        if (exchange != null) em.remove(exchange);
    }


    @Override
    public List<Exchange> findByCustomerId(Long customerId) {
        TypedQuery<Exchange> query = em.createQuery(
                "SELECT e FROM Exchange e WHERE e.customer.id = :customerId", Exchange.class);
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }

    @Override
    public List<Exchange> findByOrderId(Long orderId) {
        TypedQuery<Exchange> query = em.createQuery(
                "SELECT e FROM Exchange e WHERE e.order.id = :orderId", Exchange.class);
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }

    @Override
    public List<Exchange> findByStatus(ExchangeStatus status) {
        TypedQuery<Exchange> query = em.createQuery(
                "SELECT e FROM Exchange e WHERE e.status = :status", Exchange.class);
        query.setParameter("status", status);
        return query.getResultList();
    }
}
