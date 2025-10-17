package com.java.pink_closet.useCase.customer;

import com.java.pink_closet.dto.customer.request.CustomerUpdateRequest;
import com.java.pink_closet.dto.customer.response.CustomerResponse;
import com.java.pink_closet.execeptions.customer.CustomerNotFoundException;
import com.java.pink_closet.mapper.CustomerMapper;
import org.springframework.stereotype.Service;
import com.java.pink_closet.repositories.CustomerRepository;

@Service
public class UpdateCustomerUseCase {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public UpdateCustomerUseCase(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerResponse execute(Long id, CustomerUpdateRequest request) {
        var customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        customerMapper.toEntity(request);
        customer = customerRepository.save(customer);
        return customerMapper.toResponse(customer);
    }
}
