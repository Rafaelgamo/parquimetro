package com.parquimetro.api.dto;

import java.util.List;

public record DetalhamentoParquimetroDTO(
        String endereco,
        Float tarifaAtual,
        List<Long> vagasDisponiveis
) {
}
