package com.parquimetro.api.entitys;

import com.parquimetro.api.dto.OcupacaoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalTime;

@Entity
@Table(name = "/tb_ocupacao")
@NoArgsConstructor /* criar construtor com a propriedades de Cadastro */
@AllArgsConstructor /* cria construtor vazio */
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Ocupacao {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private LocalTime entrada;
        private String saida;
        private Long permanecia;
        private float valor = 0.40F;

        }
