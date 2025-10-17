package com.java.pink_closet.useCase.product;

import com.java.pink_closet.execeptions.product.ProductNotFoundException;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.ProductRepository;

@Service
public class DeleteProductUseCase {

    private final ProductRepository productRepository;

    public DeleteProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void execute(Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        productRepository.deleteById(id);
    }
}
