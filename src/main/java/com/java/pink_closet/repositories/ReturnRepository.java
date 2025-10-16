package com.java.pink_closet.repositories;

import com.java.pink_closet.model.Return;
import com.java.pink_closet.model.ReturnStatus;

import java.util.List;
import java.util.Optional;

public interface ReturnRepository {
    Return save(Return returnEntity);
    Optional<Return> findById(Long id);
    List<Return> findAll();
    void deleteById(Long id);
    List<Return> findByStatus(ReturnStatus status);
}