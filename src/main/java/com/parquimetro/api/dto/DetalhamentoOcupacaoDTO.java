package com.parquimetro.api.dto;

import com.parquimetro.api.entitys.Ocupacao;

import java.time.LocalTime;

public record DetalhamentoOcupacaoDTO( Long id, LocalTime entrada, String saida, Long permanencia, float valor) {

    public DetalhamentoOcupacaoDTO(Ocupacao ocupacao){
        this(ocupacao.getId(),ocupacao.getEntrada(), ocupacao.getSaida(), ocupacao.getPermanecia(), ocupacao.getValor());
    }
}
