package com.java.pink_closet.useCase.refund;

import com.java.pink_closet.dto.refund.request.RefundCreateRequest;
import com.java.pink_closet.dto.refund.response.RefundResponse;
import com.java.pink_closet.execeptions.order.OrderNotFoundException;
import com.java.pink_closet.mapper.RefundMapper;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.RefundRepository;
import com.java.pink_closet.repositories.OrderRepository;

@Service
public class CreateRefundUseCase {

    private final RefundRepository refundRepository;
    private final OrderRepository orderRepository;
    private final RefundMapper refundMapper;

    public CreateRefundUseCase(RefundRepository refundRepository, OrderRepository orderRepository, RefundMapper refundMapper) {
        this.refundRepository = refundRepository;
        this.orderRepository = orderRepository;
        this.refundMapper = refundMapper;
    }

    public RefundResponse execute(RefundCreateRequest request) {
        var order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException(request.getOrderId()));

        var refund = refundMapper.toEntity(request); // RefundRequest + Order -> Refund
        refund = refundRepository.save(refund);
        return refundMapper.toResponse(refund);
    }
}
