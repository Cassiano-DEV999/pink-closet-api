package com.java.pink_closet.useCase.payment;

import com.java.pink_closet.execeptions.payment.PaymentNotFoundException;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.PaymentRepository;

@Service
public class DeletePaymentUseCase {

    private final PaymentRepository paymentRepository;

    public DeletePaymentUseCase(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void execute(Long id) {
        var payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));
        paymentRepository.deleteById(id);
    }
}
