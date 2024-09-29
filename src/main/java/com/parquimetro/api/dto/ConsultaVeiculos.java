package com.parquimetro.api.dto;


import com.parquimetro.api.entitys.Veiculos;
import org.springframework.data.web.config.EnableSpringDataWebSupport;


import java.time.LocalDateTime;
import java.time.LocalTime;


@EnableSpringDataWebSupport
public record ConsultaVeiculos(long id, String placa, LocalDateTime dia_hora, LocalTime entrada, LocalTime saida, Long permanecia, float valor) {

    public ConsultaVeiculos(Veiculos veiculos) {
        this(veiculos.getId(), veiculos.getPlaca(), veiculos.getDia_hora(), veiculos.getEntrada(), veiculos.getSaida(), veiculos.getPermanecia(), veiculos.getValor());
    }

}
