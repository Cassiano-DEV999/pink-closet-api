package com.java.pink_closet.useCase.customer;

import com.java.pink_closet.dto.customer.response.CustomerResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import com.java.pink_closet.mapper.CustomerMapper;
import com.java.pink_closet.repositories.CustomerRepository;

@Service
public class ListCustomersUseCase {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public ListCustomersUseCase(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerResponse> execute() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponse)
                .toList();
    }
}
