package com.parquimetro.api.dto;

import com.parquimetro.api.model.Vaga;

public record VagaDTO (
        Long idParquimetro,
        boolean ocupada
) {

    public VagaDTO (Vaga vaga){
        this(vaga.getParquimetro().getId(), vaga.getOcupada());
    }
}
