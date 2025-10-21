package com.java.pink_closet.useCase.customer;

import com.java.pink_closet.dto.customer.request.CustomerCreateRequest;
import com.java.pink_closet.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateCustomerRegistrationUseCase {

    private final CustomerRepository customerRepository;

    public void execute(CustomerCreateRequest request) {
        if (customerRepository.findByEmailIgnoreCase(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }
    }
}
