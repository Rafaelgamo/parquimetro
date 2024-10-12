package com.parquimetro.api.dto;

import com.parquimetro.api.model.Ocupacao;

import java.time.LocalDateTime;

public record OcupacaoDTO(
        Long idVaga,
        Long idVeiculo,
        Integer tempoReservado,
        Float valorEmReais,
        Float tarifaAplicada,
        LocalDateTime horarioEntrada,
        LocalDateTime horarioSaida
) {
    public OcupacaoDTO(Ocupacao ocupacaoSalva) {
        this(
                ocupacaoSalva.getVaga().getId(),
                ocupacaoSalva.getVeiculo().getId(),
                ocupacaoSalva.getMinutosReservados(),
                ocupacaoSalva.getValorEmReais(),
                ocupacaoSalva.getTarifaAplicada(),
                ocupacaoSalva.getHorarioEntrada(),
                ocupacaoSalva.getHorarioSaida()
        );
    }
}
