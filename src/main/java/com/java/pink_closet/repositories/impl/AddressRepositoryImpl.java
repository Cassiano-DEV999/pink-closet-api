package com.java.pink_closet.repositories.impl;

import com.java.pink_closet.model.Address;
import com.java.pink_closet.repositories.AddressRepository;
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
public class AddressRepositoryImpl implements AddressRepository {

    private final EntityManager em;

    @Override
    public List<Address> findAll() {
        return em.createQuery("SELECT a FROM Address a", Address.class)
                .getResultList();
    }

    @Override
    public Address save(Address address) {
        if (address.getId() == null) {
            em.persist(address);
            return address;
        } else {
            return em.merge(address);
        }
    }

    @Override
    public Optional<Address> findById(Long id) {
        return Optional.ofNullable(em.find(Address.class, id));
    }

    @Override
    public void delete(Address address) {
        em.remove(em.contains(address) ? address : em.merge(address));
    }

    @Override
    public void deleteById(Long id) {
        Address address = em.find(Address.class, id);
        if (address != null) em.remove(address);
    }


    @Override
    public List<Address> findByCustomerId(Long customerId) {
        TypedQuery<Address> query = em.createQuery(
                "SELECT a FROM Address a WHERE a.customer.id = :customerId", Address.class);
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }

    @Override
    public List<Address> findByCustomerIdAndCity(Long customerId, String city) {
        TypedQuery<Address> query = em.createQuery(
                "SELECT a FROM Address a WHERE a.customer.id = :customerId AND a.city = :city", Address.class);
        query.setParameter("customerId", customerId);
        query.setParameter("city", city);
        return query.getResultList();
    }

    @Override
    public Optional<Address> findPrimaryByCustomerId(Long customerId) {
        TypedQuery<Address> query = em.createQuery(
                "SELECT a FROM Address a WHERE a.customer.id = :customerId AND a.primaryAddress = true", Address.class);
        query.setParameter("customerId", customerId);
        return query.getResultStream().findFirst();
    }

    @Override
    public List<Address> findByCustomerIdAndZipCode(Long customerId, String zipCode) {
        TypedQuery<Address> query = em.createQuery(
                "SELECT a FROM Address a WHERE a.customer.id = :customerId AND a.zipCode = :zipCode", Address.class);
        query.setParameter("customerId", customerId);
        query.setParameter("zipCode", zipCode);
        return query.getResultList();
    }
}
