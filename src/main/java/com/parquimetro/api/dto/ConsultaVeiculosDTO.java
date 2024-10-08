package com.parquimetro.api.dto;


import com.parquimetro.api.entitys.Veiculos;

public record ConsultaVeiculosDTO(Long id, String placa, String modelo, int ano) {

    public ConsultaVeiculosDTO(Veiculos veiculos) {
        this(veiculos.getId(), veiculos.getPlaca(), veiculos.getModelo(),
                veiculos.getAno());

    }

}
