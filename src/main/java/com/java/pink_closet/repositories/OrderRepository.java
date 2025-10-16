package com.java.pink_closet.repositories;

import com.java.pink_closet.model.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(Long id);
    List<Order> findAll();
    List<Order> findByCustomerId(Long customerId);
    void deleteById(Long id);
    List<Order> findByCustomerIdAndStatus(Long customerId, String status);
    List<Order> findByCustomerIdAndDateRange(Long customerId, LocalDateTime start, LocalDateTime end);
}