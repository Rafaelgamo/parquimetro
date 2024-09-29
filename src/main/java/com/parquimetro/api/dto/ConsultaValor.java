package com.parquimetro.api.dto;

import com.parquimetro.api.entitys.Veiculos;

public record ConsultaValor(Long permanecia, float valor)  {



    public ConsultaValor(Veiculos veiculos){
        this(veiculos.getPermanecia(), veiculos.getValor());
    }
}
