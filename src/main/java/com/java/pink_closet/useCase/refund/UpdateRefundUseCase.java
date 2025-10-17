package com.java.pink_closet.useCase.refund;

import com.java.pink_closet.dto.refund.request.RefundUpdateRequest;
import com.java.pink_closet.dto.refund.response.RefundResponse;
import com.java.pink_closet.execeptions.refund.RefundNotFoundException;
import com.java.pink_closet.mapper.RefundMapper;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.RefundRepository;

@Service
public class UpdateRefundUseCase {

    private final RefundRepository refundRepository;
    private final RefundMapper refundMapper;

    public UpdateRefundUseCase(RefundRepository refundRepository, RefundMapper refundMapper) {
        this.refundRepository = refundRepository;
        this.refundMapper = refundMapper;
    }

    public RefundResponse execute(Long id, RefundUpdateRequest request) {
        var refund = refundRepository.findById(id)
                .orElseThrow(() -> new RefundNotFoundException(id));
        refundMapper.toEntity(request);
        refund = refundRepository.save(refund);
        return refundMapper.toResponse(refund);
    }
}
