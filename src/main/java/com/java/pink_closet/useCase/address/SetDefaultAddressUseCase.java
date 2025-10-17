package com.java.pink_closet.useCase.address;


import com.java.pink_closet.execeptions.address.AddressNotFoundException;
import com.java.pink_closet.execeptions.customer.CustomerNotFoundException;
import com.java.pink_closet.repositories.AddressRepository;
import com.java.pink_closet.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SetDefaultAddressUseCase {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    public void execute(Long customerId, Long addressId) {
        var customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        var address = addressRepository.findById(addressId)
                .orElseThrow(() -> new AddressNotFoundException(addressId));

        if (!customer.getAddresses().contains(address)) {
            throw new IllegalArgumentException("Endereço não pertence ao cliente informado.");
        }

        customer.setPrimaryAddress(address);
        customerRepository.save(customer);
    }
}
