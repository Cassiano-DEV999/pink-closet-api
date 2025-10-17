package com.java.pink_closet.mapper;

import com.java.pink_closet.dto.customer.request.CustomerCreateRequest;
import com.java.pink_closet.dto.customer.request.CustomerUpdateRequest;
import com.java.pink_closet.dto.customer.response.CustomerDetailedResponse;
import com.java.pink_closet.dto.customer.response.CustomerResponse;
import com.java.pink_closet.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toEntity(CustomerCreateRequest request);
    Customer toEntity(CustomerUpdateRequest request);

    CustomerResponse toResponse(Customer entity);
    CustomerDetailedResponse toDetailedResponse(Customer entity);
}