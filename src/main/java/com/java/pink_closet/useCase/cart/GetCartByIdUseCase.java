package com.java.pink_closet.useCase.cart;

import com.java.pink_closet.dto.cart.response.CartDetailedResponse;
import com.java.pink_closet.execeptions.cart.CartNotFoundException;
import com.java.pink_closet.mapper.CartMapper;
import com.java.pink_closet.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCartByIdUseCase {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public CartDetailedResponse execute(Long id) {
        return cartRepository.findById(id)
                .map(cartMapper::toDetailedResponse)
                .orElseThrow(() -> new CartNotFoundException(id));
    }
}
