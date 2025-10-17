package com.java.pink_closet.useCase.cart;

import com.java.pink_closet.execeptions.cart.CartNotFoundException;
import com.java.pink_closet.execeptions.product.ProductOutOfStockException;
import com.java.pink_closet.model.Cart;
import com.java.pink_closet.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateCartItemsUseCase {

    private final CartRepository cartRepository;

    public void execute(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(cartId));

        cart.getItems().forEach(item -> {
            int requested = item.getQuantity();
            int available = item.getProduct().getStock();
            if (requested > available) {
                throw new ProductOutOfStockException(
                        item.getProduct().getId(),
                        requested,
                        available
                );
            }
        });
    }
}
