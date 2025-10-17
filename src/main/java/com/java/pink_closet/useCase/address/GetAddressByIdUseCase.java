package com.java.pink_closet.useCase.address;

import com.java.pink_closet.dto.address.response.AddressDetailedResponse;
import com.java.pink_closet.execeptions.address.AddressNotFoundException;
import com.java.pink_closet.mapper.AddressMapper;
import com.java.pink_closet.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAddressByIdUseCase {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressDetailedResponse execute(Long id) {
        return addressRepository.findById(id)
                .map(addressMapper::toDetailedResponse)
                .orElseThrow(() -> new AddressNotFoundException(id));
    }
}
