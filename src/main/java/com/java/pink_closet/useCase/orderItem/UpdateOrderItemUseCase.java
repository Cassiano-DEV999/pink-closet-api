package com.java.pink_closet.useCase.orderItem;

import com.java.pink_closet.dto.orderItem.request.OrderItemUpdateRequest;
import com.java.pink_closet.dto.orderItem.response.OrderItemResponse;
import com.java.pink_closet.execeptions.orderItem.OrderItemNotFoundException;
import com.java.pink_closet.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.OrderItemRepository;

import java.math.BigDecimal;

@Service
public class UpdateOrderItemUseCase {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    public UpdateOrderItemUseCase(OrderItemRepository orderItemRepository, OrderItemMapper orderItemMapper) {
        this.orderItemRepository = orderItemRepository;
        this.orderItemMapper = orderItemMapper;
    }

    public OrderItemResponse execute(Long id, OrderItemUpdateRequest request) {
        var orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new OrderItemNotFoundException(id));

        if (request.getQuantity() != null) orderItem.setQuantity(request.getQuantity());
        if (request.getUnitPrice() != null) orderItem.setUnitPrice(request.getUnitPrice());

        orderItem.setSubtotal(orderItem.getUnitPrice().multiply(new BigDecimal(orderItem.getQuantity())));

        orderItem = orderItemRepository.save(orderItem);
        return orderItemMapper.toResponse(orderItem);
    }
}
