package com.parquimetro.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;
import java.time.LocalTime;



public record DadosCadastroVeiculos(

        long id,
        @NotBlank
        @Pattern(regexp = "\\d{7}")
        String placa,

        LocalDateTime dia_hora,

        
        LocalTime tempo,

        float valor

        )


{


}
