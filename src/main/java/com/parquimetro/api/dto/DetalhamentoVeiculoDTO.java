package com.parquimetro.api.dto;

import com.parquimetro.api.entitys.Veiculos;

public record DetalhamentoVeiculoDTO(Long id, String placa, String modelo, int ano) {

    public DetalhamentoVeiculoDTO(Veiculos veiculos) {
        this(veiculos.getId(), veiculos.getPlaca(), veiculos.getModelo(),
                veiculos.getAno());
    }
}
