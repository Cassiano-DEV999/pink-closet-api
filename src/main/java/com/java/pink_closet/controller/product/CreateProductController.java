package com.java.pink_closet.controller.product;

import com.java.pink_closet.dto.product.request.ProductCreateRequest;
import com.java.pink_closet.dto.product.response.ProductResponse;
import com.java.pink_closet.useCase.product.CreateProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class CreateProductController {

    private final CreateProductUseCase createProductUseCase;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductCreateRequest request) {
        ProductResponse savedProduct = createProductUseCase.execute(request);
        return ResponseEntity.ok(savedProduct);
    }
}
