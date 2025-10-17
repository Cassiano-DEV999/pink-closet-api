package com.java.pink_closet.useCase.cart;

import com.java.pink_closet.dto.cart.request.CartCreateRequest;
import com.java.pink_closet.dto.cart.response.CartDetailedResponse;
import com.java.pink_closet.mapper.CartMapper;
import com.java.pink_closet.model.Cart;
import com.java.pink_closet.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCartUseCase {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public CartDetailedResponse execute(CartCreateRequest request) {
        Cart cart = cartMapper.toEntity(request);
        cart = cartRepository.save(cart);
        return cartMapper.toDetailedResponse(cart);
    }
}
