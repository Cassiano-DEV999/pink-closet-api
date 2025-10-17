package com.java.pink_closet.useCase.cartItem;

import com.java.pink_closet.dto.cartItem.response.CartItemResponse;
import com.java.pink_closet.mapper.CartItemMapper;
import com.java.pink_closet.repositories.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCartItemByIdUseCase {

    private final CartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;

    public CartItemResponse execute(Long id) {
        return cartItemRepository.findById(id)
                .map(cartItemMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Cart item not found with id: " + id));
    }
}
