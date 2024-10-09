package com.parquimetro.api.entitys;

import com.parquimetro.api.dto.VeiculosDTO;
import jakarta.persistence.*;
import lombok.*;

 /* informa que é uma  entidade do banco de dados*/
@Entity
@Table(name = "/tb_veiculos")
@Getter
@NoArgsConstructor /* criar construtor com a propriedades de Cadastro */
@AllArgsConstructor /* cria construtor vazio */
@EqualsAndHashCode(of = "id")
public class Veiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String modelo;
    private int ano;

    public Veiculos(VeiculosDTO dados) {
        this.placa = dados.placa();
        this.modelo = dados.modelo();
        this.ano = dados.ano();
    }
}



