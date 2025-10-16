package com.java.pink_closet.repositories.impl;

import com.java.pink_closet.model.Return;
import com.java.pink_closet.model.ReturnStatus;
import com.java.pink_closet.repositories.ReturnRepository;
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
public class ReturnRepositoryImpl implements ReturnRepository {

    private final EntityManager em;

    @Override
    public Return save(Return returnEntity) {
        if (returnEntity.getId() == null) {
            em.persist(returnEntity);
            return returnEntity;
        } else {
            return em.merge(returnEntity);
        }
    }

    @Override
    public Optional<Return> findById(Long id) {
        return Optional.ofNullable(em.find(Return.class, id));
    }

    @Override
    public void deleteById(Long id) {
        Return returnEntity = em.find(Return.class, id);
        if (returnEntity != null) em.remove(returnEntity);
    }

    @Override
    public List<Return> findAll() {
        return em.createQuery("SELECT r FROM Return r", Return.class)
                .getResultList();
    }
    @Override
    public List<Return> findByStatus(ReturnStatus status) {
        TypedQuery<Return> query = em.createQuery(
                "SELECT r FROM Return r WHERE r.status = :status", Return.class);
        query.setParameter("status", status);
        return query.getResultList();
    }
}
