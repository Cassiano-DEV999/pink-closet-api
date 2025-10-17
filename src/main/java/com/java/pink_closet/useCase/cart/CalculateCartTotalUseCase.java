package com.java.pink_closet.useCase.cart;

import com.java.pink_closet.execeptions.cart.CartNotFoundException;
import com.java.pink_closet.model.Cart;
import com.java.pink_closet.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CalculateCartTotalUseCase {

    private final CartRepository cartRepository;

    public BigDecimal execute(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(cartId));

        return cart.getItems().stream()
                .map(item ->
                        item.getProduct().getPrice()
                                .multiply(new BigDecimal(item.getQuantity()))
                )
                .reduce(BigDecimal.ZERO, BigDecimal::add); // soma tudo
    }
}
