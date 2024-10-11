package com.parquimetro.api.dto;

import com.parquimetro.api.entitys.Endereco;
import com.parquimetro.api.entitys.Parquimetros;

public record ConsultaParquimetroDTO(Long id, Endereco endereco, int quantidadeVagas, Boolean vagalivre ) {

    public ConsultaParquimetroDTO(Parquimetros parquimetros) {
        this(parquimetros.getId(), parquimetros.getEndereco(),
                parquimetros.getQuantidadeVagas(),parquimetros.getVagalivre());
    }
}
