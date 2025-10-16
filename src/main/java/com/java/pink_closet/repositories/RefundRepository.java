package com.java.pink_closet.repositories;

import com.java.pink_closet.model.Refund;
import com.java.pink_closet.model.RefundStatus;

import java.util.List;
import java.util.Optional;

public interface RefundRepository {
    Refund save(Refund refund);
    Optional<Refund> findById(Long id);
    List<Refund> findAll();
    void deleteById(Long id);
    List<Refund> findByStatus(RefundStatus status);
}