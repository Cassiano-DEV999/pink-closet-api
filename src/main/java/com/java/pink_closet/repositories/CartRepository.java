package com.java.pink_closet.repositories;

import com.java.pink_closet.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartRepository {
    Cart save(Cart cart);
    Optional<Cart> findById(Long id);
    Optional<Cart> findActiveCartByCustomerId(Long customerId);
    List<Cart> findByCustomerId(Long customerId);
    List<Cart> findAll();
    void deleteById(Long id);
    void deleteActiveCartByCustomerId(Long customerId);
}
