package com.java.pink_closet.utils;

import com.java.pink_closet.utils.dto.ViaCepResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;


@Component
public class ViaCepClient {

    private final WebClient webClient;

    public ViaCepClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://viacep.com.br/ws").build();
    }

    public ViaCepResponse buscarEnderecoPorCep(String cep) {
        try {
            return webClient.get()
                    .uri("/{cep}/json", cep)
                    .retrieve()
                    .bodyToMono(ViaCepResponse.class)
                    .block();
        } catch (WebClientResponseException e) {
            throw new RuntimeException("Erro ao buscar CEP: " + cep, e);
        }
    }
}
