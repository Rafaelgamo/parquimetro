package com.parquimetro.api.dto;

import com.parquimetro.api.model.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public record VeiculoDTO(
        Long id,
        @NotBlank
        @Pattern(regexp = "\\d{7}", message = "Formato da placa invalido")
        String placa,
        @NotBlank
        String modelo,
        @NotBlank
        Integer anoFabricacao
) {
    public VeiculoDTO (Veiculo veiculo) {
        this(veiculo.getId(), veiculo.getPlaca(), veiculo.getModelo(), veiculo.getAnoFabricacao());
    }
}
