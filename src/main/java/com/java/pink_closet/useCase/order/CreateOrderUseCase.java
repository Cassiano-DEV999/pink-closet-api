package com.java.pink_closet.useCase.order;

import com.java.pink_closet.dto.order.request.OrderCreateRequest;
import com.java.pink_closet.dto.order.response.OrderResponse;
import com.java.pink_closet.execeptions.customer.CustomerNotFoundException;
import com.java.pink_closet.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.OrderRepository;
import com.java.pink_closet.repositories.CustomerRepository;

@Service
public class CreateOrderUseCase {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final OrderMapper orderMapper;

    public CreateOrderUseCase(OrderRepository orderRepository, CustomerRepository customerRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.orderMapper = orderMapper;
    }

    public OrderResponse execute(OrderCreateRequest request) {
        var customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException(request.getCustomerId()));

        var order = orderMapper.toEntity(request);

        order.setCustomer(customer);

        order.setOrderDate(java.time.LocalDateTime.now());
        order.setUpdatedAt(java.time.LocalDateTime.now());


        order = orderRepository.save(order);
        return orderMapper.toResponse(order);
    }
}
