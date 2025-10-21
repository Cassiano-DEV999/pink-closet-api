package com.java.pink_closet.controller.product;

import com.java.pink_closet.dto.product.request.ProductUpdateRequest;
import com.java.pink_closet.dto.product.response.ProductResponse;
import com.java.pink_closet.useCase.product.UpdateProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class UpdateProductController {

    private final UpdateProductUseCase updateProductUseCase;

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id,
                                                         @RequestBody ProductUpdateRequest request) {
        ProductResponse updatedProduct = updateProductUseCase.execute(id, request);
        return ResponseEntity.ok(updatedProduct);
    }
}
