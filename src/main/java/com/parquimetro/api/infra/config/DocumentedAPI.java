package com.parquimetro.api.infra.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Parquimetro API",
                version = "0.0.1-mvp",
                description = "Parquimetro API MVP - Tech Challenge Fase 2",
                contact = @Contact(
                        name = "Grupo 14 - 5ADJT",
                        email = "caioalves_diogo@hotmail.com"
                )
        )
)
public interface DocumentedAPI { }