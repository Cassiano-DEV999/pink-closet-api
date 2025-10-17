package com.java.pink_closet.useCase.address;

import com.java.pink_closet.dto.address.response.AddressResponse;
import com.java.pink_closet.mapper.AddressMapper;
import com.java.pink_closet.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListAddressUseCase {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public List<AddressResponse> execute() {
        return addressRepository.findAll()
                .stream()
                .map(addressMapper::toResponse)
                .collect(Collectors.toList());
    }
}
