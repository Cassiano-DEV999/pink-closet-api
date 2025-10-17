package com.java.pink_closet.repositories;

import com.java.pink_closet.model.Payment;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
    Payment save(Payment payment);
    Optional<Payment> findById(Long id);
    List<Payment> findByOrderId(Long orderId);
    void deleteById(Long id);
    List<Payment> findAll();
}