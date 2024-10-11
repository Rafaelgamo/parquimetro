package com.parquimetro.api.entitys;

import com.parquimetro.api.dto.ParquimetrosDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "/tb_parquimetros")
@EqualsAndHashCode(of = "id")
@Getter
@NoArgsConstructor /* criar construtor com a propriedades de Cadastro */
@AllArgsConstructor /* cria construtor vazio */
public class Parquimetros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Endereco endereco;
    private int quantidadeVagas;
    private Boolean vagalivre;


    public Parquimetros(ParquimetrosDTO dados){
        this.endereco = new Endereco(dados.endereco());
        this.quantidadeVagas = dados.quantidadeVagas();
        this.vagalivre = dados.vagalivre();
    }

}

