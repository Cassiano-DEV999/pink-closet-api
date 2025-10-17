package com.java.pink_closet.useCase.cart;

import com.java.pink_closet.execeptions.cart.CartNotFoundException;
import com.java.pink_closet.model.Cart;
import com.java.pink_closet.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCartUseCase {

    private final CartRepository cartRepository;

    public void execute(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));

        cartRepository.deleteActiveCartByCustomerId(cart.getCustomer().getId());
    }
}
