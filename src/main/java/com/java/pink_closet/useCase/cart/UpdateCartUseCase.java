package com.java.pink_closet.useCase.cart;

import com.java.pink_closet.dto.cart.request.CartUpdateRequest;
import com.java.pink_closet.dto.cart.response.CartDetailedResponse;
import com.java.pink_closet.execeptions.cart.CartNotFoundException;
import com.java.pink_closet.mapper.CartMapper;
import com.java.pink_closet.model.Cart;
import com.java.pink_closet.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCartUseCase {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public CartDetailedResponse execute(Long id, CartUpdateRequest request) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));

        if (request.getActive() != null) {
            cart.setActive(request.getActive());
        }

        cart = cartRepository.save(cart);
        return cartMapper.toDetailedResponse(cart);
    }
}
