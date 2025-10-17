package com.java.pink_closet.useCase.manager;

import com.java.pink_closet.dto.manager.request.ManagerUpdateRequest;
import com.java.pink_closet.execeptions.manager.ManagerNotFoundException;
import com.java.pink_closet.model.Manager;
import com.java.pink_closet.repositories.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UpdateManagerUseCase {

    private final ManagerRepository managerRepository;

    public Manager execute(Long id, ManagerUpdateRequest request) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new ManagerNotFoundException(id));

        if (request.getName() != null) manager.setName(request.getName());
        if (request.getEmail() != null) manager.setEmail(request.getEmail());
        if (request.getPassword() != null) manager.setPassword(request.getPassword());
        if (request.getPhone() != null) manager.setPhone(request.getPhone());
        if (request.getRole() != null) manager.setRole(request.getRole());
        manager.setActive(request.isActive());

        // Atualiza a data automaticamente
        manager.setUpdatedAt(LocalDateTime.now());

        return managerRepository.save(manager);
    }
}
