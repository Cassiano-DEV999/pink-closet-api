package com.java.pink_closet.repositories;

import com.java.pink_closet.model.Manager;
import com.java.pink_closet.model.ManagerRole;

import java.util.List;
import java.util.Optional;

public interface ManagerRepository {

    Manager save(Manager manager);
    Optional<Manager> findById(Long id);
    void deleteById(Long id);
    List<Manager> findAll();
    Optional<Manager> findByEmail(String email);
    List<Manager> findByRole(ManagerRole role);
    List<Manager> findByActive(boolean active);
    Optional<Manager> findActiveById(Long id);
    List<Manager> findAllActive();
}
