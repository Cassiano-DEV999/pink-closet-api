package com.java.pink_closet.useCase.exchange;

import com.java.pink_closet.dto.exchange.response.ExchangeResponse;
import com.java.pink_closet.execeptions.exchange.ExchangeNotFoundException;
import com.java.pink_closet.mapper.ExchangeMapper;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.ExchangeRepository;

@Service
public class GetExchangeByIdUseCase {

    private final ExchangeRepository exchangeRepository;
    private final ExchangeMapper exchangeMapper;

    public GetExchangeByIdUseCase(ExchangeRepository exchangeRepository, ExchangeMapper exchangeMapper) {
        this.exchangeRepository = exchangeRepository;
        this.exchangeMapper = exchangeMapper;
    }

    public ExchangeResponse execute(Long id) {
        var exchange = exchangeRepository.findById(id)
                .orElseThrow(() -> new ExchangeNotFoundException(id));
        return exchangeMapper.toResponse(exchange);
    }
}
