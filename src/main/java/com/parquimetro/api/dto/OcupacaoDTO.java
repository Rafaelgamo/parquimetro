package com.parquimetro.api.dto;


import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;

public record OcupacaoDTO(

        LocalTime entrada,
        String saida,
        long permanencia,
        float valor,
        boolean Status
) {


}
