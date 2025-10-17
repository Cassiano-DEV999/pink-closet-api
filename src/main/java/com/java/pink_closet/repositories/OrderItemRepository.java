package com.java.pink_closet.repositories;

import com.java.pink_closet.model.OrderItem;
import java.util.List;
import java.util.Optional;

public interface OrderItemRepository {
    OrderItem save(OrderItem item);
    Optional<OrderItem> findById(Long id);
    List<OrderItem> findByOrderId(Long orderId);
    void deleteById(Long id);
    List<OrderItem> findAll();
}
