package com.java.pink_closet.repositories.impl;

import com.java.pink_closet.model.Customer;
import com.java.pink_closet.repositories.CustomerRespository;
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
public class CustomerRepositoryImpl implements CustomerRespository {

    private final EntityManager em;

    @Override
    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            em.persist(customer);
            return customer;
        } else {
            return em.merge(customer);
        }
    }

    @Override
    public Customer findById(Long id) {
        return em.find(Customer.class, id);
    }

    @Override
    public void deleteById(Long id) {
        Customer customer = em.find(Customer.class, id);
        if (customer != null) em.remove(customer);
    }

    @Override
    public List<Customer> findAll() {
        return em.createQuery("SELECT c FROM Customer c", Customer.class)
                .getResultList();
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        TypedQuery<Customer> query = em.createQuery(
                "SELECT c FROM Customer c WHERE c.email = :email", Customer.class);
        query.setParameter("email", email);
        return query.getResultStream().findFirst();
    }

    @Override
    public List<Customer> findByActive(boolean active) {
        TypedQuery<Customer> query = em.createQuery(
                "SELECT c FROM Customer c WHERE c.active = :active", Customer.class);
        query.setParameter("active", active);
        return query.getResultList();
    }

    @Override
    public Optional<Customer> findActiveById(Long id) {
        TypedQuery<Customer> query = em.createQuery(
                "SELECT c FROM Customer c WHERE c.id = :id AND c.active = true", Customer.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst();
    }

    @Override
    public List<Customer> findAllActive() {
        TypedQuery<Customer> query = em.createQuery(
                "SELECT c FROM Customer c WHERE c.active = true", Customer.class);
        return query.getResultList();
    }
}
