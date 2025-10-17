package com.java.pink_closet.mapper;


import com.java.pink_closet.dto.address.request.AddressCreateRequest;
import com.java.pink_closet.dto.address.request.AddressUpdateRequest;
import com.java.pink_closet.dto.address.response.AddressDetailedResponse;
import com.java.pink_closet.dto.address.response.AddressResponse;
import com.java.pink_closet.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address toEntity(AddressCreateRequest request);
    Address toEntity(AddressUpdateRequest request);

    AddressResponse toResponse(Address entity);
    AddressDetailedResponse toDetailedResponse(Address entity);
}