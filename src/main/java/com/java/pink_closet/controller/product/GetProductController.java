package com.java.pink_closet.controller.product;

import com.java.pink_closet.dto.product.response.ProductResponse;
import com.java.pink_closet.useCase.product.GetProductByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class GetProductController {

    private final GetProductByIdUseCase getProductByIdUseCase;

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        ProductResponse product = getProductByIdUseCase.execute(id);
        return ResponseEntity.ok(product);
    }
}
