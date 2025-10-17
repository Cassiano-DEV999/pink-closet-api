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
public class RejectExchangeUseCase {

    private final ExchangeRepository exchangeRepository;

    public Exchange execute(Long exchangeId, String rejectionReason) {
        Exchange exchange = exchangeRepository.findById(exchangeId)
                .orElseThrow(() -> new ExchangeNotFoundException(exchangeId));

        exchange.setStatus(ExchangeStatus.CANCELLED);
        exchange.setProcessedAt(LocalDateTime.now());

        String existingNotes = exchange.getNotes() != null ? exchange.getNotes() + "\n" : "";
        exchange.setNotes(existingNotes + "Rejeição: " + rejectionReason);

        return exchangeRepository.save(exchange);
    }
}
