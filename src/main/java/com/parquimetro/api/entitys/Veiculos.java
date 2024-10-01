package com.parquimetro.api.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.parquimetro.api.dto.DadosCadastroVeiculosDTO;
import jakarta.persistence.*;

import lombok.*;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;



@Table(name ="parquimetro")  /* informa a tabela banco de dados*/
@Entity(name = "Parquimetro") /* informa que é uma  entidade do banco de dados*/
@Getter
@Setter
@NoArgsConstructor /* criar construtor com a propriedades de Cadastro */
@AllArgsConstructor /* cria construtor vazio */
@EqualsAndHashCode(of = "id")
public class Veiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private LocalDateTime dia_hora;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime entrada;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime saida;

    private Long permanecia ;
    private float valor = 0.40f;



    public Veiculos(DadosCadastroVeiculosDTO dados) {
        this.placa = dados.placa();
        this.dia_hora = LocalDateTime.now();
        this.entrada = LocalTime.now();
        this.saida = dados.saida();
        this.permanecia = Duration.between(entrada, saida).toMinutes(); /* exibe direfença entre o tempo de entrada e saida */
        this.valor = permanecia *  valor/ 15;  /* regra de calculo */



    }

    }



