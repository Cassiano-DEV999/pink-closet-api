package com.java.pink_closet.useCase.cart;

import com.java.pink_closet.execeptions.cart.CartNotFoundException;
import com.java.pink_closet.model.Cart;
import com.java.pink_closet.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClearCartUseCase {

    private final CartRepository cartRepository;

    @Transactional
    public void execute(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(cartId));

        cart.getItems().clear();
        cartRepository.save(cart);
    }
}
