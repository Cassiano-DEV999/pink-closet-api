package com.java.pink_closet.useCase.orderItem;

import com.java.pink_closet.dto.orderItem.response.OrderItemResponse;
import com.java.pink_closet.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import com.java.pink_closet.repositories.OrderItemRepository;

@Service
public class ListOrderItemsUseCase {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    public ListOrderItemsUseCase(OrderItemRepository orderItemRepository, OrderItemMapper orderItemMapper) {
        this.orderItemRepository = orderItemRepository;
        this.orderItemMapper = orderItemMapper;
    }

    public List<OrderItemResponse> execute() {
        return orderItemRepository.findAll()
                .stream()
                .map(orderItemMapper::toResponse)
                .toList();
    }
}
