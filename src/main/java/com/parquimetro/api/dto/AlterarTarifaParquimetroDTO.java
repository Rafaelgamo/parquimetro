package com.parquimetro.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AlterarTarifaParquimetroDTO(
        @NotNull @Positive Long idParquimetro,
        @NotNull @Positive Float novoValorTarifa
) { }
