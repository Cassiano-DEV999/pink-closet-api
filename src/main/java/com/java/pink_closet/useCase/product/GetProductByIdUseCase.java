package com.java.pink_closet.useCase.product;

import com.java.pink_closet.dto.product.response.ProductResponse;
import com.java.pink_closet.execeptions.product.ProductNotFoundException;
import org.springframework.stereotype.Service;
import com.java.pink_closet.mapper.ProductMapper;
import com.java.pink_closet.repositories.ProductRepository;

@Service
public class GetProductByIdUseCase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public GetProductByIdUseCase(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse execute(Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return productMapper.toResponse(product);
    }
}
