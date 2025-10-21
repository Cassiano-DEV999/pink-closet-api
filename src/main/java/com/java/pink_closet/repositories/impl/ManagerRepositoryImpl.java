package com.java.pink_closet.repositories.impl;

import com.java.pink_closet.model.Manager;
import com.java.pink_closet.model.ManagerRole;
import com.java.pink_closet.repositories.ManagerRepository;
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
public class ManagerRepositoryImpl implements ManagerRepository {

    private final EntityManager em;

    @Override
    public Manager save(Manager manager) {
        if (manager.getId() == null) {
            em.persist(manager);
            return manager;
        } else {
            return em.merge(manager);
        }
    }

    @Override
    public Optional<Manager> findById(Long id) {
        return Optional.ofNullable(em.find(Manager.class, id));
    }

    @Override
    public void deleteById(Long id) {
        Manager manager = em.find(Manager.class, id);
        if (manager != null) em.remove(manager);
    }

    @Override
    public List<Manager> findAll() {
        return em.createQuery("SELECT m FROM Manager m", Manager.class).getResultList();
    }

    @Override
    public Optional<Manager> findByEmail(String email) {
        TypedQuery<Manager> query = em.createQuery(
                "SELECT m FROM Manager m WHERE m.email = :email", Manager.class);
        query.setParameter("email", email);
        return query.getResultStream().findFirst();
    }

    @Override
    public List<Manager> findByRole(ManagerRole role) {
        TypedQuery<Manager> query = em.createQuery(
                "SELECT m FROM Manager m WHERE m.role = :role", Manager.class);
        query.setParameter("role", role);
        return query.getResultList();
    }

    @Override
    public List<Manager> findByActive(boolean active) {
        TypedQuery<Manager> query = em.createQuery(
                "SELECT m FROM Manager m WHERE m.active = :active", Manager.class);
        query.setParameter("active", active);
        return query.getResultList();
    }

    @Override
    public Optional<Manager> findActiveById(Long id) {
        TypedQuery<Manager> query = em.createQuery(
                "SELECT m FROM Manager m WHERE m.id = :id AND m.active = true", Manager.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst();
    }

    @Override
    public List<Manager> findAllActive() {
        TypedQuery<Manager> query = em.createQuery(
                "SELECT m FROM Manager m WHERE m.active = true", Manager.class);
        return query.getResultList();
    }

    @Override
    public Optional<Manager> findByEmailIgnoreCase(String email) {
        TypedQuery<Manager> query = em.createQuery(
                "SELECT m FROM Manager m WHERE LOWER(m.email) = LOWER(:email)", Manager.class);
        query.setParameter("email", email);
        return query.getResultStream().findFirst();
    }
}
