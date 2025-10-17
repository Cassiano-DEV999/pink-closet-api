package com.java.pink_closet.useCase.cartItem;

import com.java.pink_closet.dto.cartItem.request.CartItemUpdateRequest;
import com.java.pink_closet.dto.cartItem.response.CartItemResponse;
import com.java.pink_closet.mapper.CartItemMapper;
import com.java.pink_closet.model.CartItem;
import com.java.pink_closet.repositories.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCartItemUseCase {

    private final CartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;

    public CartItemResponse execute(Long id, CartItemUpdateRequest request) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CartItem not found with id: " + id));

        if (request.getQuantity() != null) cartItem.setQuantity(request.getQuantity());

        cartItem = cartItemRepository.save(cartItem);
        return cartItemMapper.toResponse(cartItem);
    }
}
