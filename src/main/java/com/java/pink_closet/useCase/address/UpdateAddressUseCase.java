package com.java.pink_closet.useCase.address;

import com.java.pink_closet.dto.address.request.AddressUpdateRequest;
import com.java.pink_closet.dto.address.response.AddressDetailedResponse;
import com.java.pink_closet.execeptions.address.AddressNotFoundException;
import com.java.pink_closet.mapper.AddressMapper;
import com.java.pink_closet.model.Address;
import com.java.pink_closet.repositories.AddressRepository;
import com.java.pink_closet.utils.dto.ViaCepResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateAddressUseCase {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final ValidateAddressUseCase validateAddressUseCase; // injetado

    public AddressDetailedResponse execute(Long id, AddressUpdateRequest request) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(id));

        if (request.getZipCode() != null) {
            ViaCepResponse enderecoViaCep = validateAddressUseCase.execute(request.getZipCode());
            if (enderecoViaCep.getLogradouro() != null) request.setStreet(enderecoViaCep.getLogradouro());
            if (enderecoViaCep.getBairro() != null) request.setNeighborhood(enderecoViaCep.getBairro());
            if (enderecoViaCep.getLocalidade() != null) request.setCity(enderecoViaCep.getLocalidade());
            if (enderecoViaCep.getUf() != null) request.setState(enderecoViaCep.getUf());
        }

        if (request.getStreet() != null) address.setStreet(request.getStreet());
        if (request.getNumber() != null) address.setNumber(request.getNumber());
        if (request.getComplement() != null) address.setComplement(request.getComplement());
        if (request.getNeighborhood() != null) address.setNeighborhood(request.getNeighborhood());
        if (request.getCity() != null) address.setCity(request.getCity());
        if (request.getState() != null) address.setState(request.getState());
        if (request.getZipCode() != null) address.setZipCode(request.getZipCode());

        address = addressRepository.save(address);

        return addressMapper.toDetailedResponse(address);
    }
}
