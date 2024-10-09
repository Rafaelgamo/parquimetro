package com.parquimetro.api.entitys;

import com.parquimetro.api.dto.EnderecoDTO;
import com.parquimetro.api.enums.Estado;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Endereco {
    private Estado estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String cep;


    public Endereco(EnderecoDTO dados) {
        this.cidade = dados.cidade();
        this.bairro = dados.bairro();
        this.logradouro = dados.logradouro();
        this.cep = dados.cep();
    }

}
