package com.parquimetro.api.dto;

import com.parquimetro.api.entitys.Veiculo;

import java.time.LocalDateTime;
import java.time.LocalTime;


public record DadosDetalhamentoVeiculoDTO(Long id, String placa, LocalDateTime dia_hora, LocalTime entrada,
                                          LocalTime saida, Long permanecia, float valor) {

    /*public DadosDetalhamentoVeiculoDTO(Veiculo veiculo) {
        this(veiculo.getId(), veiculo.getPlaca(), veiculo.getDia_hora(),
                veiculo.getEntrada(), veiculo.getSaida(), veiculo.getPermanecia(),
                veiculo.getValor());

    }*/
}
