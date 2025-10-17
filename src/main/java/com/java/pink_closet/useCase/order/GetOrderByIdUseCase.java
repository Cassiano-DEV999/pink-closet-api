package com.java.pink_closet.useCase.order;

import com.java.pink_closet.dto.order.response.OrderResponse;
import com.java.pink_closet.execeptions.order.OrderNotFoundException;
import com.java.pink_closet.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.OrderRepository;

@Service
public class GetOrderByIdUseCase {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public GetOrderByIdUseCase(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public OrderResponse execute(Long id) {
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return orderMapper.toResponse(order);
    }
}
