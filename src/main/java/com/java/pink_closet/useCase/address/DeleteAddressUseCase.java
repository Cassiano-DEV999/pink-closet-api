package com.java.pink_closet.useCase.address;

import com.java.pink_closet.execeptions.address.AddressNotFoundException;
import com.java.pink_closet.execeptions.address.AddressUnauthorizedException;
import com.java.pink_closet.model.Address;
import com.java.pink_closet.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteAddressUseCase {

    private final AddressRepository addressRepository;

    public void execute(Long addressId, Long customerId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new AddressNotFoundException(addressId));

        if (!address.getCustomer().getId().equals(customerId)) {
            throw new AddressUnauthorizedException(addressId);
        }

        addressRepository.delete(address);
    }
}
