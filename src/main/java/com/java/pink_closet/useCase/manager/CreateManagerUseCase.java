package com.java.pink_closet.useCase.manager;

import com.java.pink_closet.dto.manager.request.ManagerCreateRequest;
import com.java.pink_closet.dto.manager.response.ManagerResponse;
import com.java.pink_closet.execeptions.manager.ManagerAlreadyExistsException;
import com.java.pink_closet.mapper.ManagerMapper;
import com.java.pink_closet.model.Manager;
import com.java.pink_closet.repositories.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateManagerUseCase {

    private final ManagerRepository managerRepository;
    private final ManagerMapper managerMapper;

    public ManagerResponse execute(ManagerCreateRequest request) {
        managerRepository.findByEmail(request.getEmail())
                .ifPresent(m -> { throw new ManagerAlreadyExistsException(request.getEmail()); });

        Manager manager = managerMapper.toEntity(request);
        manager = managerRepository.save(manager);
        return managerMapper.toResponse(manager);
    }
}
