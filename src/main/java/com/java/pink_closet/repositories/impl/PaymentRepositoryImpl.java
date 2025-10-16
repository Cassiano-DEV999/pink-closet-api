package com.java.pink_closet.repositories.impl;

import com.java.pink_closet.model.Payment;
import com.java.pink_closet.repositories.PaymentRepository;
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
public class PaymentRepositoryImpl implements PaymentRepository {

    private final EntityManager em;


    @Override
    public Payment save(Payment payment) {
        if (payment.getId() == null) {
            em.persist(payment);
            return payment;
        } else {
            return em.merge(payment);
        }
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return Optional.ofNullable(em.find(Payment.class, id));
    }

    @Override
    public void deleteById(Long id) {
        Payment payment = em.find(Payment.class, id);
        if (payment != null) em.remove(payment);
    }


    @Override
    public List<Payment> findByOrderId(Long orderId) {
        TypedQuery<Payment> query = em.createQuery(
                "SELECT p FROM Payment p WHERE p.order.id = :orderId", Payment.class);
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }
}
