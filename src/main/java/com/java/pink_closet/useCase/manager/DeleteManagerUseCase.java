package com.java.pink_closet.useCase.manager;

import com.java.pink_closet.execeptions.manager.ManagerNotFoundException;
import com.java.pink_closet.repositories.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteManagerUseCase {

    private final ManagerRepository managerRepository;

    public void execute(Long id) {
        var manager = managerRepository.findById(id)
                .orElseThrow(() -> new ManagerNotFoundException(id));
        managerRepository.deleteById(id);
    }
}
