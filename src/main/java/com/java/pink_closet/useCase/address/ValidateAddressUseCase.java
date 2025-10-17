package com.java.pink_closet.useCase.address;

import com.java.pink_closet.execeptions.address.InvalidAddressException;
import org.springframework.stereotype.Service;
import com.java.pink_closet.utils.ViaCepClient;
import com.java.pink_closet.utils.dto.ViaCepResponse;

@Service
public class ValidateAddressUseCase {

    private final ViaCepClient viaCepClient;

    public ValidateAddressUseCase(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }


    public ViaCepResponse execute(String zipCode) {
        if (zipCode == null || !zipCode.matches("\\d{8}")) {
            throw new InvalidAddressException("CEP inválido: deve conter 8 números.");
        }

        ViaCepResponse endereco = viaCepClient.buscarEnderecoPorCep(zipCode);

        if (endereco == null || endereco.getCep() == null) {
            throw new InvalidAddressException("CEP não encontrado via ViaCEP: " + zipCode);
        }

        return endereco;
    }
}
