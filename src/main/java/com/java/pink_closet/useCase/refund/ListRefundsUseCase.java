package com.java.pink_closet.useCase.refund;

import com.java.pink_closet.dto.refund.response.RefundResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import com.java.pink_closet.mapper.RefundMapper;
import com.java.pink_closet.repositories.RefundRepository;

@Service
public class ListRefundsUseCase {

    private final RefundRepository refundRepository;
    private final RefundMapper refundMapper;

    public ListRefundsUseCase(RefundRepository refundRepository, RefundMapper refundMapper) {
        this.refundRepository = refundRepository;
        this.refundMapper = refundMapper;
    }

    public List<RefundResponse> execute() {
        return refundRepository.findAll()
                .stream()
                .map(refundMapper::toResponse)
                .toList();
    }
}
