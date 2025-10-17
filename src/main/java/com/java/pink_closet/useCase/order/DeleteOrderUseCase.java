package com.java.pink_closet.useCase.order;

import com.java.pink_closet.execeptions.order.OrderNotFoundException;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.OrderRepository;

@Service
public class DeleteOrderUseCase {

    private final OrderRepository orderRepository;

    public DeleteOrderUseCase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void execute(Long id) {
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        orderRepository.deleteById(id);
    }
}
