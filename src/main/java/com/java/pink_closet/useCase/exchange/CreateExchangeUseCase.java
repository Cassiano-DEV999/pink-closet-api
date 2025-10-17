package com.java.pink_closet.useCase.exchange;

import com.java.pink_closet.dto.exchange.request.ExchangeCreateRequest;
import com.java.pink_closet.dto.exchange.response.ExchangeResponse;
import com.java.pink_closet.execeptions.orderItem.OrderItemNotFoundException;
import com.java.pink_closet.mapper.ExchangeMapper;
import com.java.pink_closet.model.ExchangeStatus;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.ExchangeRepository;
import com.java.pink_closet.repositories.OrderItemRepository;

@Service
public class CreateExchangeUseCase {

    private final ExchangeRepository exchangeRepository;
    private final OrderItemRepository orderItemRepository;
    private final ExchangeMapper exchangeMapper;

    public CreateExchangeUseCase(ExchangeRepository exchangeRepository,
                                 OrderItemRepository orderItemRepository,
                                 ExchangeMapper exchangeMapper) {
        this.exchangeRepository = exchangeRepository;
        this.orderItemRepository = orderItemRepository;
        this.exchangeMapper = exchangeMapper;
    }

    public ExchangeResponse execute(ExchangeCreateRequest request) {
        var orderItem = orderItemRepository.findById(request.getOrderItemId())
                .orElseThrow(() -> new OrderItemNotFoundException(request.getOrderItemId()));

        var exchange = exchangeMapper.toEntity(request);

        exchange.setStatus(ExchangeStatus.REQUESTED);
        exchange.setRequestedAt(java.time.LocalDateTime.now());

        exchange.setCustomer(orderItem.getOrder().getCustomer());
        exchange.setOrder(orderItem.getOrder());

        exchange = exchangeRepository.save(exchange);
        return exchangeMapper.toResponse(exchange);
    }
}
