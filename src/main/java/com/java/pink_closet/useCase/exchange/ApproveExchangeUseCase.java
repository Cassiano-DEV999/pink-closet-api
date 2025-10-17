package com.java.pink_closet.useCase.exchange;

import com.java.pink_closet.execeptions.exchange.ExchangeNotFoundException;
import com.java.pink_closet.model.Exchange;
import com.java.pink_closet.model.ExchangeStatus;
import com.java.pink_closet.repositories.ExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ApproveExchangeUseCase {

    private final ExchangeRepository exchangeRepository;

    public Exchange execute(Long exchangeId) {
        Exchange exchange = exchangeRepository.findById(exchangeId)
                .orElseThrow(() -> new ExchangeNotFoundException(exchangeId));

        exchange.setStatus(ExchangeStatus.APPROVED);
        exchange.setProcessedAt(LocalDateTime.now());

        return exchangeRepository.save(exchange);
    }
}
