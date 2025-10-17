package com.java.pink_closet.useCase.cartItem;
import com.java.pink_closet.dto.cartItem.request.CartItemCreateRequest;
import com.java.pink_closet.dto.cartItem.response.CartItemResponse;
import com.java.pink_closet.execeptions.cart.CartNotFoundException;
import com.java.pink_closet.mapper.CartItemMapper;
import com.java.pink_closet.model.Cart;
import com.java.pink_closet.model.CartItem;
import com.java.pink_closet.repositories.CartItemRepository;
import com.java.pink_closet.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCartItemUseCase {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;

    public CartItemResponse execute(Long cartId, CartItemCreateRequest request) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(cartId));

        CartItem cartItem = cartItemMapper.toEntity(request);
        cartItem.setCart(cart);

        cartItem = cartItemRepository.save(cartItem);
        return cartItemMapper.toResponse(cartItem);
    }
}
