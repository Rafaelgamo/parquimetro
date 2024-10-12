package com.parquimetro.api.controller;

import com.parquimetro.api.entitys.Vaga;
import com.parquimetro.api.services.VagaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name ="/vagas")
public class VagaController {

    private final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @PostMapping

    @GetMapping
    public ResponseEntity<List<Vaga>> listarOcupacao() {
        var page = vagaService.listarVagasDisponveis();
        return ResponseEntity.ok(page);
    }
}

