package com.java.pink_closet.useCase.cartItem;

import com.java.pink_closet.dto.cartItem.response.CartItemResponse;
import com.java.pink_closet.mapper.CartItemMapper;
import com.java.pink_closet.repositories.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListCartItemsUseCase {

    private final CartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;

    public List<CartItemResponse> execute(Long cartId) {
        return cartItemRepository.findByCartId(cartId)
                .stream()
                .map(cartItemMapper::toResponse)
                .collect(Collectors.toList());
    }
}
