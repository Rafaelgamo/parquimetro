package com.parquimetro.api.dto;

import com.parquimetro.api.entitys.Ocupacao;

import java.time.LocalDateTime;

public record DetalhamentoOcupacaoDTO(
        Long id,
        LocalDateTime entrada,
        LocalDateTime saida,
        Integer permanencia,
        Float valor
) {

    public DetalhamentoOcupacaoDTO(Ocupacao ocupacao) {
        this(
                ocupacao.getId(),
                ocupacao.getHorarioEntrada(),
                ocupacao.getHorarioSaida(),
                ocupacao.getMinutosReservados(),
                ocupacao.getValorEmReais()
        );
    }
}
