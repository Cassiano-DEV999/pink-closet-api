package com.java.pink_closet.useCase.payment;

import com.java.pink_closet.dto.payment.request.PaymentUpdateRequest;
import com.java.pink_closet.dto.payment.response.PaymentResponse;
import com.java.pink_closet.execeptions.payment.PaymentNotFoundException;
import com.java.pink_closet.mapper.PaymentMapper;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.PaymentRepository;

@Service
public class UpdatePaymentUseCase {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public UpdatePaymentUseCase(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    public PaymentResponse execute(Long id, PaymentUpdateRequest request) {
        var payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));
        paymentMapper.toEntity(request);
        payment = paymentRepository.save(payment);
        return paymentMapper.toResponse(payment);
    }
}
