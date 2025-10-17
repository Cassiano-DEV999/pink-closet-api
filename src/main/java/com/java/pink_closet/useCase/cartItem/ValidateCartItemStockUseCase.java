package com.java.pink_closet.useCase.cartItem;


import com.java.pink_closet.execeptions.cart.CartItemNotFoundException;
import com.java.pink_closet.execeptions.product.ProductOutOfStockException;
import com.java.pink_closet.model.CartItem;
import com.java.pink_closet.repositories.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateCartItemStockUseCase {

    private final CartItemRepository cartItemRepository;

    public void execute(Long cartItemId) {
        CartItem item = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new CartItemNotFoundException("CartItem not found with id: " + cartItemId));

        int requested = item.getQuantity();
        int available = item.getProduct().getStock();

        if (requested > available) {
            throw new ProductOutOfStockException(item.getProduct().getId(), requested, available);
        }
    }
}
