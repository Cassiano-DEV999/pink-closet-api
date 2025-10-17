package com.java.pink_closet.useCase.manager;

import com.java.pink_closet.model.Manager;
import com.java.pink_closet.repositories.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListManagersUseCase {

    private final ManagerRepository managerRepository;

    public List<Manager> execute() {
        return managerRepository.findAll();
    }
}
