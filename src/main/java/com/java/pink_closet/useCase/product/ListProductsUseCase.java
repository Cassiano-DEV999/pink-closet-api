package com.java.pink_closet.useCase.product;

import com.java.pink_closet.dto.product.response.ProductResponse;
import com.java.pink_closet.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import com.java.pink_closet.repositories.ProductRepository;

@Service
public class ListProductsUseCase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ListProductsUseCase(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductResponse> execute() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }
}
