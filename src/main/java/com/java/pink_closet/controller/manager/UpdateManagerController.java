package com.java.pink_closet.controller.manager;

import com.java.pink_closet.model.Manager;
import com.java.pink_closet.repositories.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class UpdateManagerController {

    private final ManagerRepository managerRepository;

    @PutMapping("/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable Long id,
                                                 @RequestBody Manager managerDetails) {
        Optional<Manager> optionalManager = managerRepository.findById(id);
        if (optionalManager.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Manager manager = optionalManager.get();
        manager.setName(managerDetails.getName());
        manager.setEmail(managerDetails.getEmail());
        // atualize outros campos necessários
        managerRepository.save(manager);

        return ResponseEntity.ok(manager);
    }
}
