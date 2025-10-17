package com.java.pink_closet.useCase.manager;

import com.java.pink_closet.execeptions.manager.ManagerNotFoundException;
import com.java.pink_closet.model.Manager;
import com.java.pink_closet.repositories.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetManagerByIdUseCase {

    private final ManagerRepository managerRepository;

    public Manager execute(Long managerId) {
        return managerRepository.findById(managerId)
                .orElseThrow(() -> new ManagerNotFoundException(managerId));
    }
}
