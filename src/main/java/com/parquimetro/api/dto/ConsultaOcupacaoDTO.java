package com.parquimetro.api.dto;

import com.parquimetro.api.entitys.Ocupacao;

import java.time.LocalTime;

public record ConsultaOcupacaoDTO(Long id, LocalTime entrada, String saida, Long permanencia, float valor) {

    public ConsultaOcupacaoDTO(Ocupacao ocupacao) {
           this(ocupacao.getId(), ocupacao.getEntrada(),
                   ocupacao.getSaida(), ocupacao.getPermanecia(),
                   ocupacao.getValor());
}
}
