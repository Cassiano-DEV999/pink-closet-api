package com.java.pink_closet.controller.manager;

import com.java.pink_closet.useCase.manager.DeleteManagerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class DeleteManagerController {

    private final DeleteManagerUseCase deleteManagerUseCase;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManager(@PathVariable Long id) {
        deleteManagerUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
