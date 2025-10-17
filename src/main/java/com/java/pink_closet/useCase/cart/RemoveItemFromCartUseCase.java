package com.java.pink_closet.useCase.cart;

import com.java.pink_closet.repositories.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveItemFromCartUseCase {

    private final CartItemRepository cartItemRepository;

    public void execute(Long cartItemId) {
        var item = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Cart item not found: " + cartItemId));

        cartItemRepository.deleteByCartId(cartItemId);
    }
}
