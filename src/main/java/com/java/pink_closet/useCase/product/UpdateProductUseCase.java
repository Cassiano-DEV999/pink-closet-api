package com.java.pink_closet.useCase.product;

import com.java.pink_closet.dto.product.request.ProductUpdateRequest;
import com.java.pink_closet.dto.product.response.ProductResponse;
import com.java.pink_closet.execeptions.product.ProductNotFoundException;
import com.java.pink_closet.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.ProductRepository;

@Service
public class UpdateProductUseCase {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public UpdateProductUseCase(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse execute(Long id, ProductUpdateRequest request) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        productMapper.toEntity(request);
        product = productRepository.save(product);
        return productMapper.toResponse(product);
    }
}
