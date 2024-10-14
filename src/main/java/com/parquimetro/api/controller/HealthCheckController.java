package com.parquimetro.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "healthcheck", description = "Checar estado de disponibilidade da API")
@RestController
@RequestMapping("/hello-world")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<String> info() {
        return ResponseEntity.ok("\nPARQUIMETRO-API: Rodando\n");
    }

}
