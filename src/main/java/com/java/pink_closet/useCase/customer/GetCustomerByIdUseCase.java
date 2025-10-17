package com.java.pink_closet.useCase.customer;

import com.java.pink_closet.dto.customer.response.CustomerResponse;
import com.java.pink_closet.execeptions.customer.CustomerNotFoundException;
import org.springframework.stereotype.Service;
import com.java.pink_closet.mapper.CustomerMapper;
import com.java.pink_closet.repositories.CustomerRepository;

@Service
public class GetCustomerByIdUseCase {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public GetCustomerByIdUseCase(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerResponse execute(Long id) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        return customerMapper.toResponse(customer);
    }
}
