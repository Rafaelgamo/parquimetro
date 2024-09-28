package com.parquimetro.api.enums;


import com.parquimetro.api.dto.DadosCadastroVeiculos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Table(name ="parquimetro")  /* informa a tabela banco de dados*/
@Entity(name = "Parquimetro") /* informa que é uma  entidade do banco de dados*/
@Getter
@NoArgsConstructor /* criar construtor com a propriedades de Cadastro */
@AllArgsConstructor /* cria construtor vazio */
@EqualsAndHashCode(of = "id")
public class Veiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    LocalDateTime dia_hora;
    LocalTime tempo;
    private float valor;


    public Veiculos(DadosCadastroVeiculos dados) {
        this.placa = dados.placa();
        this.dia_hora = LocalDateTime.now();
        this.tempo = dados.tempo();
        this.valor = dados.valor();


    }
}



