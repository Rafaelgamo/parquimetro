package com.parquimetro.api.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record OcuparVagaDTO(
        @NotNull @Positive Long idVaga,
        @NotNull
        @Pattern(regexp="([a-zA-Z]{3}-\\d{4})", message = "Formato de placa invalido, formato esperado: ABC-1234")
        String placaVeiculo,
        @NotNull
        @Positive
        Integer tempoEmMinutos
) { }