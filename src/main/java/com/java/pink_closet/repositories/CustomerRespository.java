package com.java.pink_closet.repositories;

import com.java.pink_closet.model.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerRespository {
    Customer save(Customer customer);
    Customer findById(Long id);
    Optional<Customer> findByEmail(String email);
    void deleteById(Long id);
    List<Customer> findAll();
    List<Customer> findByActive(boolean active);
    Optional<Customer> findActiveById(Long id);
    List<Customer> findAllActive();

}
