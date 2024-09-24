package com.parquimetro.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record DadosCadastro(

        long id,
        @NotBlank
        @Pattern(regexp = "\\d{7}")
        String placa,
        @NotBlank
        String data,
        @NotBlank
        String valor) {



}
