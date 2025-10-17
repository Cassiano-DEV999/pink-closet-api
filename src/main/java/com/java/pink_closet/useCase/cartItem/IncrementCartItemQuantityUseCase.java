package com.java.pink_closet.useCase.cartItem;


import com.java.pink_closet.execeptions.cart.CartItemNotFoundException;
import com.java.pink_closet.execeptions.product.ProductOutOfStockException;
import com.java.pink_closet.model.CartItem;
import com.java.pink_closet.repositories.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncrementCartItemQuantityUseCase {

    private final CartItemRepository cartItemRepository;

    public CartItem execute(Long cartItemId, int incrementBy) {
        CartItem item = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new CartItemNotFoundException("CartItem not found with id: " + cartItemId));

        int newQuantity = item.getQuantity() + incrementBy;

        if (newQuantity > item.getProduct().getStock()) {
            throw new ProductOutOfStockException(
                    item.getProduct().getId(),
                    newQuantity,
                    item.getProduct().getStock()
            );
        }

        item.setQuantity(newQuantity);
        return cartItemRepository.save(item);
    }
}
