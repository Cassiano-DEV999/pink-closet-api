package com.java.pink_closet.useCase.refund;

import com.java.pink_closet.execeptions.refund.RefundNotFoundException;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.RefundRepository;

@Service
public class DeleteRefundUseCase {

    private final RefundRepository refundRepository;

    public DeleteRefundUseCase(RefundRepository refundRepository) {
        this.refundRepository = refundRepository;
    }

    public void execute(Long id) {
        var refund = refundRepository.findById(id)
                .orElseThrow(() -> new RefundNotFoundException(id));
        refundRepository.deleteById(id);
    }
}
