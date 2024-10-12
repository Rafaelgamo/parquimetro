package com.parquimetro.api.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record OcuparVagaDTO(
        @NotNull @Positive Long idVaga,
        @NotNull @Positive Long idVeiculo,
        @NotNull
        @Positive
        @Pattern(regexp = "(15|30|45|60|75|90|105|120)",
                message = "Tempo Invalido para reserva... Opcoes de tempo para reservar (em minutos): 15, 30, 45, 60, 75, 90, 105, 120")
        Integer tempoEmMinutos
) { }