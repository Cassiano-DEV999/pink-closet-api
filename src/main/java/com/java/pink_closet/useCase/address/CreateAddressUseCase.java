package com.java.pink_closet.useCase.address;

import com.java.pink_closet.dto.address.request.AddressCreateRequest;
import com.java.pink_closet.dto.address.response.AddressDetailedResponse;
import com.java.pink_closet.execeptions.customer.CustomerNotFoundException;
import com.java.pink_closet.mapper.AddressMapper;
import com.java.pink_closet.model.Address;
import com.java.pink_closet.repositories.AddressRepository;
import com.java.pink_closet.repositories.CustomerRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAddressUseCase {

    private final AddressRepository addressRepository;
    private final CustomerRespository customerRespository;
    private final AddressMapper addressMapper;

    public AddressDetailedResponse execute(AddressCreateRequest request) {
        customerRespository.findById(request.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException(request.getCustomerId()));

        Address address = addressMapper.toEntity(request);

        address = addressRepository.save(address);

        return addressMapper.toDetailedResponse(address);
    }
}
