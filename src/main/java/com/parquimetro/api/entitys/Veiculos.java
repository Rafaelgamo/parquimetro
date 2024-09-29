package com.parquimetro.api.entitys;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.parquimetro.api.dto.DadosCadastroVeiculos;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Duration;
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
    private LocalDateTime dia_hora;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime entrada;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime saida;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM")
    private long permanecia;
    private private valor;




    public Veiculos(DadosCadastroVeiculos dados) {
        this.placa = dados.placa();
        this.dia_hora = LocalDateTime.now();
        this.entrada = dados.entrada();
        this.saida = dados.saida();
        this.permanecia = Duration.between(entrada, saida).toMinutes();
        this.valor = dados.valor();


    }


}
