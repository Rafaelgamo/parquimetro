package com.parquimetro.api.dto;

import java.util.List;

public record HistoricoVeiculoDTO(
        String placa,
        String modelo,
        Integer anoFabricacao,
        List<ItemHistoricoVeiculoDTO> listaDeOcupacoes
) {
}
