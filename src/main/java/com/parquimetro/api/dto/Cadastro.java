package com.parquimetro.api.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Table(name ="parquimetro")
@Entity(name = "Parquimetro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String data;
    private String valor;

    public Cadastro(DadosCadastro dados){
        this.placa = dados.placa();
        this.data = dados.data();
        this.valor = dados.valor();
    }

}


