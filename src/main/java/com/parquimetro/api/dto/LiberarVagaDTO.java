package com.parquimetro.api.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record LiberarVagaDTO(
        @NotNull @Positive Long idVaga,
        @NotBlank
        @Pattern(regexp="([a-zA-Z]{3}-\\d{4})", message = "Formato de placa invalido, formato esperado: ABC-1234")
        String placa
) { }