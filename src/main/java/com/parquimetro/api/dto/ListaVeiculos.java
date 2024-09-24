package com.parquimetro.api.dto;

import org.springframework.data.web.config.EnableSpringDataWebSupport;


@EnableSpringDataWebSupport
public record ListaVeiculos (long id, String placa, String data, String valor) {

    public ListaVeiculos(Cadastro cadastro) {
        this(cadastro.getId(), cadastro.getPlaca(), cadastro.getData(), cadastro.getValor());
    }

}
