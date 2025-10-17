package com.java.pink_closet.useCase.orderItem;

import com.java.pink_closet.dto.orderItem.request.OrderItemCreateRequest;
import com.java.pink_closet.dto.orderItem.response.OrderItemResponse;
import com.java.pink_closet.execeptions.order.OrderNotFoundException;
import com.java.pink_closet.execeptions.product.ProductNotFoundException;
import com.java.pink_closet.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.OrderItemRepository;
import com.java.pink_closet.repositories.OrderRepository;
import com.java.pink_closet.repositories.ProductRepository;

import java.math.BigDecimal;

@Service
public class CreateOrderItemUseCase {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderItemMapper orderItemMapper;

    public CreateOrderItemUseCase(OrderItemRepository orderItemRepository, OrderRepository orderRepository,
                                  ProductRepository productRepository, OrderItemMapper orderItemMapper) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderItemMapper = orderItemMapper;
    }

    public OrderItemResponse execute(OrderItemCreateRequest request) {
        var order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException(request.getOrderId()));
        var product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ProductNotFoundException(request.getProductId()));

        var orderItem = orderItemMapper.toEntity(request);

        orderItem.setOrder(order);
        orderItem.setProduct(product);

        orderItem.setSubtotal(orderItem.getUnitPrice().multiply(new BigDecimal(orderItem.getQuantity())));

        orderItem = orderItemRepository.save(orderItem);
        return orderItemMapper.toResponse(orderItem);
    }
}
