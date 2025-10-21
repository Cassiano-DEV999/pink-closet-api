package com.java.pink_closet.controller.product;

import com.java.pink_closet.dto.product.response.ProductResponse;
import com.java.pink_closet.useCase.product.ListProductsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ListProductsController {

    private final ListProductsUseCase listProductsUseCase;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public ResponseEntity<List<ProductResponse>> listProducts() {
        List<ProductResponse> products = listProductsUseCase.execute();
        return ResponseEntity.ok(products);
    }
}
