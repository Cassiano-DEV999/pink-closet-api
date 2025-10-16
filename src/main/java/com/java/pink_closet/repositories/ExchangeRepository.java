package com.java.pink_closet.repositories;

import com.java.pink_closet.model.Exchange;
import com.java.pink_closet.model.ExchangeStatus;

import java.util.List;
import java.util.Optional;

public interface ExchangeRepository {
    Exchange save(Exchange exchange);
    Optional<Exchange> findById(Long id);
    List<Exchange> findAll();
    void deleteById(Long id);
    List<Exchange> findByCustomerId(Long customerId);
    List<Exchange> findByOrderId(Long orderId);
    List<Exchange> findByStatus(ExchangeStatus status);
}