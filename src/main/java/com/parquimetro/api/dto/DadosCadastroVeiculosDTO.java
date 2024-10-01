package com.parquimetro.api.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import java.time.LocalDateTime;
import java.time.LocalTime;


@EnableSpringDataWebSupport
public record DadosCadastroVeiculosDTO(

        @NotBlank
        @Pattern(regexp = "\\d{7}")
        String placa,

        LocalDateTime dia_hora,

        LocalTime entrada,
        LocalTime saida,
        Long permanencia,

        @NotBlank
        float valor

        )


{



}
