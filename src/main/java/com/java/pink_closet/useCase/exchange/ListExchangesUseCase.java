package com.java.pink_closet.useCase.exchange;

import com.java.pink_closet.dto.exchange.response.ExchangeResponse;
import com.java.pink_closet.mapper.ExchangeMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import com.java.pink_closet.repositories.ExchangeRepository;

@Service
public class ListExchangesUseCase {

    private final ExchangeRepository exchangeRepository;
    private final ExchangeMapper exchangeMapper;

    public ListExchangesUseCase(ExchangeRepository exchangeRepository, ExchangeMapper exchangeMapper) {
        this.exchangeRepository = exchangeRepository;
        this.exchangeMapper = exchangeMapper;
    }

    public List<ExchangeResponse> execute() {
        return exchangeRepository.findAll()
                .stream()
                .map(exchangeMapper::toResponse)
                .toList();
    }
}
