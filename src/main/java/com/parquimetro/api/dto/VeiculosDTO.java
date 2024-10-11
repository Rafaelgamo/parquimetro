package com.parquimetro.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public record VeiculosDTO(

        @NotBlank  @Pattern(regexp = "\\d{7}")
        String placa,
        @NotBlank
        String modelo,
        @NotBlank
        int ano
        )
         {

         }
