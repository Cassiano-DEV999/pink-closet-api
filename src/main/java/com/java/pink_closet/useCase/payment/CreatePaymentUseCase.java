package com.java.pink_closet.useCase.payment;

import com.java.pink_closet.dto.payment.request.PaymentCreateRequest;
import com.java.pink_closet.dto.payment.response.PaymentResponse;
import com.java.pink_closet.execeptions.order.OrderNotFoundException;
import com.java.pink_closet.mapper.PaymentMapper;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.PaymentRepository;
import com.java.pink_closet.repositories.OrderRepository;

@Service
public class CreatePaymentUseCase {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final PaymentMapper paymentMapper;

    public CreatePaymentUseCase(PaymentRepository paymentRepository, OrderRepository orderRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
        this.paymentMapper = paymentMapper;
    }

    public PaymentResponse execute(PaymentCreateRequest request) {
        var order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException(request.getOrderId()));

        var payment = paymentMapper.toEntity(request);
        payment = paymentRepository.save(payment);
        return paymentMapper.toResponse(payment);
    }
}
