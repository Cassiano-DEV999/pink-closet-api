package com.java.pink_closet.repositories;

import com.java.pink_closet.model.CartItem;
import java.util.List;
import java.util.Optional;

public interface CartItemRepository{
    CartItem save(CartItem cartItem);
    Optional<CartItem> findById(Long id);
    List<CartItem> findByCartId(Long cartId);
    Optional<CartItem> findByCartIdAndProductId(Long cartId, Long productId);
    List<CartItem> findSelectedByCartId(Long cartId);
    void deleteById(Long id);
    void deleteByCartId(Long cartId);
}
