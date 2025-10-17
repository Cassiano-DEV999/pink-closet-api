package com.java.pink_closet.useCase.customer;

import com.java.pink_closet.dto.customer.request.CustomerCreateRequest;
import com.java.pink_closet.dto.customer.response.CustomerResponse;
import com.java.pink_closet.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import com.java.pink_closet.mapper.CustomerMapper;

@Service
public class CreateCustomerUseCase {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CreateCustomerUseCase(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerResponse execute(CustomerCreateRequest request) {
        var customer = customerMapper.toEntity(request);
        customer = customerRepository.save(customer);
        return customerMapper.toResponse(customer);
    }
}
