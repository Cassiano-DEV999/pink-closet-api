package com.java.pink_closet.useCase.cartItem;

import com.java.pink_closet.execeptions.cart.CartItemNotFoundException;
import com.java.pink_closet.model.CartItem;
import com.java.pink_closet.repositories.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DecrementCartItemQuantityUseCase {

    private final CartItemRepository cartItemRepository;

    public void execute(Long cartItemId, int decrementBy) {
        CartItem item = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new CartItemNotFoundException("CartItem not found with id: " + cartItemId));

        int newQuantity = item.getQuantity() - decrementBy;

        if (newQuantity <= 0) {
            cartItemRepository.deleteById(cartItemId);
        } else {
            item.setQuantity(newQuantity);
            cartItemRepository.save(item);
        }
    }
}
