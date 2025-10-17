package com.java.pink_closet.useCase.exchange;

import com.java.pink_closet.execeptions.exchange.ExchangeNotFoundException;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.ExchangeRepository;

@Service
public class DeleteExchangeUseCase {

    private final ExchangeRepository exchangeRepository;

    public DeleteExchangeUseCase(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    public void execute(Long id) {
        var exchange = exchangeRepository.findById(id)
                .orElseThrow(() -> new ExchangeNotFoundException(id));
        exchangeRepository.deleteById(id);
    }
}
