package com.parquimetro.api.dto;


import com.parquimetro.api.entitys.Veiculo;
import org.springframework.data.web.config.EnableSpringDataWebSupport;


import java.time.LocalDateTime;
import java.time.LocalTime;


@EnableSpringDataWebSupport
public record ConsultaVeiculosDTO(long id, String placa, LocalDateTime dia_hora,
                                  LocalTime entrada, LocalTime saida, Long permanecia, float valor) {



//    public ConsultaVeiculosDTO(Veiculo veiculo) {
//        this(veiculo.getId(), veiculo.getPlaca(), veiculo.getDia_hora(), veiculo.getEntrada(),
//                veiculo.getSaida(), veiculo.getPermanecia(),
//                veiculo.getValor());
//
//
//
//    }


}
