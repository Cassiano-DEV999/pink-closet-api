package com.java.pink_closet.useCase.address;

import com.java.pink_closet.dto.address.request.AddressCreateRequest;
import com.java.pink_closet.dto.address.response.AddressDetailedResponse;
import com.java.pink_closet.execeptions.customer.CustomerNotFoundException;
import com.java.pink_closet.mapper.AddressMapper;
import com.java.pink_closet.model.Address;
import com.java.pink_closet.model.Customer;
import com.java.pink_closet.repositories.AddressRepository;
import com.java.pink_closet.repositories.CustomerRepository;
import com.java.pink_closet.utils.dto.ViaCepResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAddressUseCase {

    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;
    private final AddressMapper addressMapper;
    private final ValidateAddressUseCase validateAddressUseCase; // injetado

    public AddressDetailedResponse execute(AddressCreateRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException(request.getCustomerId()));

        ViaCepResponse enderecoViaCep = validateAddressUseCase.execute(request.getZipCode());
        if (enderecoViaCep.getLogradouro() != null) request.setStreet(enderecoViaCep.getLogradouro());
        if (enderecoViaCep.getBairro() != null) request.setNeighborhood(enderecoViaCep.getBairro());
        if (enderecoViaCep.getLocalidade() != null) request.setCity(enderecoViaCep.getLocalidade());
        if (enderecoViaCep.getUf() != null) request.setState(enderecoViaCep.getUf());

        Address address = addressMapper.toEntity(request);

        address = addressRepository.save(address);

        return addressMapper.toDetailedResponse(address);
    }
}
