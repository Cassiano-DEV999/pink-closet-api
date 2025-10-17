package com.java.pink_closet.useCase.order;

import com.java.pink_closet.dto.order.response.OrderResponse;
import com.java.pink_closet.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import com.java.pink_closet.repositories.OrderRepository;

@Service
public class ListOrdersUseCase {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public ListOrdersUseCase(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public List<OrderResponse> execute() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toResponse)
                .toList();
    }
}
