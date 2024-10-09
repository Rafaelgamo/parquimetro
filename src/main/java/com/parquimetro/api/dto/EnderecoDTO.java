package com.parquimetro.api.dto;


public record EnderecoDTO(
        String estado,
        String cidade,
        String bairro,
        String logradouro,
        String cep
) {
}
