package com.java.pink_closet.useCase.orderItem;

import com.java.pink_closet.execeptions.orderItem.OrderItemNotFoundException;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.OrderItemRepository;

@Service
public class DeleteOrderItemUseCase {

    private final OrderItemRepository orderItemRepository;

    public DeleteOrderItemUseCase(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public void execute(Long id) {
        var orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new OrderItemNotFoundException(id));
        orderItemRepository.deleteById(orderItem.getId());
    }
}
