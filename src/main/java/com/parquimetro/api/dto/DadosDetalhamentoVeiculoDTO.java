package com.parquimetro.api.dto;

import com.parquimetro.api.entitys.Veiculos;

import java.time.LocalDateTime;
import java.time.LocalTime;


public record DadosDetalhamentoVeiculoDTO(Long id, String placa, LocalDateTime dia_hora, LocalTime entrada,
                                          LocalTime saida, Long permanecia, float valor) {

    public DadosDetalhamentoVeiculoDTO(Veiculos veiculos) {
        this(veiculos.getId(), veiculos.getPlaca(), veiculos.getDia_hora(),
                veiculos.getEntrada(), veiculos.getSaida(), veiculos.getPermanecia(),
                veiculos.getValor());

    }
}
