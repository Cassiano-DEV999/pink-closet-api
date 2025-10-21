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
public class GetManagerController {

    private final ManagerRepository managerRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Manager> getManager(@PathVariable Long id) {
        Optional<Manager> manager = managerRepository.findById(id);
        return manager.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
