package com.java.pink_closet.useCase.product;

import com.java.pink_closet.dto.product.request.ProductCreateRequest;
import com.java.pink_closet.dto.product.response.ProductResponse;
import org.springframework.stereotype.Service;
import com.java.pink_closet.mapper.ProductMapper;
import com.java.pink_closet.repositories.ProductRepository;

@Service
public class CreateProductUseCase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public CreateProductUseCase(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse execute(ProductCreateRequest request) {
        var product = productMapper.toEntity(request);
        product = productRepository.save(product);
        return productMapper.toResponse(product);
    }
}
