package com.java.pink_closet.controller.manager;

import com.java.pink_closet.model.Manager;
import com.java.pink_closet.repositories.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class ListManagersController {

    private final ManagerRepository managerRepository;

    @GetMapping
    public ResponseEntity<List<Manager>> listManagers() {
        List<Manager> managers = managerRepository.findAll();
        return ResponseEntity.ok(managers);
    }
}
