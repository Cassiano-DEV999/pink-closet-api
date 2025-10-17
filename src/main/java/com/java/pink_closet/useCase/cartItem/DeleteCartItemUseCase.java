package com.java.pink_closet.useCase.cartItem;


import com.java.pink_closet.model.CartItem;
import com.java.pink_closet.repositories.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCartItemUseCase {

    private final CartItemRepository cartItemRepository;

    public void execute(Long id) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart item not found with id: " + id));

        cartItemRepository.deleteById(cartItem.getId());
    }
}
