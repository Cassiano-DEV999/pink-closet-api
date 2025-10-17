package com.java.pink_closet.useCase.customer;

import com.java.pink_closet.execeptions.customer.CustomerNotFoundException;
import com.java.pink_closet.model.Customer;
import com.java.pink_closet.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateCustomerUseCase {

    private final CustomerRepository customerRepository;

    public Customer execute(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }
}
