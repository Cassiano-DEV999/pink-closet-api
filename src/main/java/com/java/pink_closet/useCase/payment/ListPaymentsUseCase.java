package com.java.pink_closet.useCase.payment;

import com.java.pink_closet.dto.payment.response.PaymentResponse;
import com.java.pink_closet.mapper.PaymentMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import com.java.pink_closet.repositories.PaymentRepository;

@Service
public class ListPaymentsUseCase {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public ListPaymentsUseCase(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    public List<PaymentResponse> execute() {
        return paymentRepository.findAll()
                .stream()
                .map(paymentMapper::toResponse)
                .toList();
    }
}
