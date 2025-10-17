package com.java.pink_closet.useCase.cart;

import com.java.pink_closet.dto.cart.response.CartResponse;
import com.java.pink_closet.mapper.CartMapper;
import com.java.pink_closet.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListCartUseCase {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public List<CartResponse> execute() {
        return cartRepository.findAll()
                .stream()
                .map(cartMapper::toResponse)
                .collect(Collectors.toList());
    }
}
