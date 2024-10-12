package com.parquimetro.api.dto;


public record OcuparVagaDTO(
        Integer permanencia,
        float valor,
        boolean Status
) { }