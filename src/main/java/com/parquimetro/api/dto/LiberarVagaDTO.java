package com.parquimetro.api.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record LiberarVagaDTO(
        @NotNull @Positive Long idVaga,
        @NotNull @Positive Long idVeiculo
) { }