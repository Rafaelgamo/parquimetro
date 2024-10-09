package com.parquimetro.api.dto;

import jakarta.validation.constraints.NotBlank;

public record ParquimetrosDTO(
         @NotBlank
         EnderecoDTO endereco,
         @NotBlank
         int quantidadeVagas,
         @NotBlank
         String tempo,
         @NotBlank
         Boolean vagalivre

         )
        {

        }
