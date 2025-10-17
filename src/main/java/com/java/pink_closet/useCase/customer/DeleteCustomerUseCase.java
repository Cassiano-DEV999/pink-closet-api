package com.java.pink_closet.useCase.customer;

import com.java.pink_closet.execeptions.customer.CustomerNotFoundException;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.CustomerRepository;

@Service
public class DeleteCustomerUseCase {

    private final CustomerRepository customerRepository;

    public DeleteCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void execute(Long id) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        customerRepository.deleteById(id);
    }
}
