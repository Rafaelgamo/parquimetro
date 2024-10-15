package com.parquimetro.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "healthcheck", description = "Checar estado de disponibilidade da API")
@RestController
@RequestMapping("/")
public class HealthCheckController {

    private static final ApiInfo info = new ApiInfo("PARQUIMETRO-API: Rodando", "/swagger-ui.html");

    @GetMapping(path = {"/", "/hello-world"})
    public ResponseEntity info() {
        return ResponseEntity.ok(info);
    }

    private record ApiInfo (String info, String documentacao) {}
}
