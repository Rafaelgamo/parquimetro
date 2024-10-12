package com.parquimetro.api.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record OcuparVagaDTO(
        @NotNull @Positive Long idVaga,
        @NotNull @Size(min = 7, max = 10)  String placaVeiculo,
        @NotNull
        @Positive
        Integer tempoEmMinutos
) { }