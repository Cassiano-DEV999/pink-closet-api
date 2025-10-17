package com.java.pink_closet.useCase.orderItem;

import com.java.pink_closet.dto.orderItem.response.OrderItemResponse;
import com.java.pink_closet.execeptions.orderItem.OrderItemNotFoundException;
import com.java.pink_closet.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.OrderItemRepository;

@Service
public class GetOrderItemByIdUseCase {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    public GetOrderItemByIdUseCase(OrderItemRepository orderItemRepository, OrderItemMapper orderItemMapper) {
        this.orderItemRepository = orderItemRepository;
        this.orderItemMapper = orderItemMapper;
    }

    public OrderItemResponse execute(Long id) {
        var orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new OrderItemNotFoundException(id));
        return orderItemMapper.toResponse(orderItem);
    }
}
