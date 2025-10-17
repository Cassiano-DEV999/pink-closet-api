package com.java.pink_closet.useCase.refund;

import com.java.pink_closet.dto.refund.response.RefundResponse;
import com.java.pink_closet.execeptions.refund.RefundNotFoundException;
import com.java.pink_closet.mapper.RefundMapper;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.RefundRepository;

@Service
public class GetRefundByIdUseCase {

    private final RefundRepository refundRepository;
    private final RefundMapper refundMapper;

    public GetRefundByIdUseCase(RefundRepository refundRepository, RefundMapper refundMapper) {
        this.refundRepository = refundRepository;
        this.refundMapper = refundMapper;
    }

    public RefundResponse execute(Long id) {
        var refund = refundRepository.findById(id)
                .orElseThrow(() -> new RefundNotFoundException(id));
        return refundMapper.toResponse(refund);
    }
}
