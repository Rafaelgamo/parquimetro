package com.parquimetro.api.dto;

import com.parquimetro.api.model.Parquimetro;

import java.util.List;

public record DetalhamentoParquimetroDTO(
        String endereco,
        Float tarifaAtual,
        List<Long> vagasDisponiveis
) {
    public DetalhamentoParquimetroDTO(Parquimetro parquimetro, List<Long> vagasDoParquimetro) {
        this(
                parquimetro.getEndereco(),
                parquimetro.getValorTarifaAtual(),
                vagasDoParquimetro
        );
    }
}
