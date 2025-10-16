package com.java.pink_closet.repositories.impl;

import com.java.pink_closet.model.Refund;
import com.java.pink_closet.model.RefundStatus;
import com.java.pink_closet.repositories.RefundRepository;
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
public class RefundRepositoryImpl implements RefundRepository {

    private final EntityManager em;

    @Override
    public Refund save(Refund refund) {
        if (refund.getId() == null) {
            em.persist(refund);
            return refund;
        } else {
            return em.merge(refund);
        }
    }

    @Override
    public Optional<Refund> findById(Long id) {
        return Optional.ofNullable(em.find(Refund.class, id));
    }

    @Override
    public void deleteById(Long id) {
        Refund refund = em.find(Refund.class, id);
        if (refund != null) em.remove(refund);
    }

    @Override
    public List<Refund> findAll() {
        return em.createQuery("SELECT r FROM Refund r", Refund.class)
                .getResultList();
    }

    @Override
    public List<Refund> findByStatus(RefundStatus status) {
        TypedQuery<Refund> query = em.createQuery(
                "SELECT r FROM Refund r WHERE r.status = :status", Refund.class);
        query.setParameter("status", status);
        return query.getResultList();
    }
}
