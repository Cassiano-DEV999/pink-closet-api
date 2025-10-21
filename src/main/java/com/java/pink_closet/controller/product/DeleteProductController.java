package com.java.pink_closet.controller.product;

import com.java.pink_closet.useCase.product.DeleteProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class DeleteProductController {

    private final DeleteProductUseCase deleteProductUseCase;

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        deleteProductUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
