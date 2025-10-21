package com.java.pink_closet.controller.manager;

import com.java.pink_closet.model.Manager;
import com.java.pink_closet.repositories.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class CreateManagerController {

    private final ManagerRepository managerRepository;

    @PostMapping
    public ResponseEntity<Manager> createManager(@RequestBody Manager manager) {
        Manager saved = managerRepository.save(manager);
        return ResponseEntity.ok(saved);
    }
}
