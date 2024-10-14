package com.parquimetro.api.dto;

import com.parquimetro.api.model.Ocupacao;

import java.time.LocalDateTime;

public record ItemHistoricoVeiculoDTO(
        Long idParquimetro,
        String enderecoParquimetro,
        LocalDateTime horaEntrada,
        LocalDateTime horaSaida
) {

    public ItemHistoricoVeiculoDTO (Ocupacao ocupacao) {
        this(
                ocupacao.getVaga().getParquimetro().getId(),
                ocupacao.getVaga().getParquimetro().getEndereco(),
                ocupacao.getHorarioEntrada(),
                ocupacao.getHorarioSaida()
        );
    }
}