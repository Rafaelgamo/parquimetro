package com.parquimetro.api.dto;

import com.parquimetro.api.entitys.Endereco;
import com.parquimetro.api.entitys.Parquimetros;

public record DetalhamentoParquimetroDTO(Long id, Endereco endereco, int quantidadeVagas, Boolean vagalivre ) {

    public DetalhamentoParquimetroDTO(Parquimetros parquimetros) {
        this(parquimetros.getId(), parquimetros.getEndereco(),
                parquimetros.getQuantidadeVagas(), parquimetros.getVagalivre());
    }
}