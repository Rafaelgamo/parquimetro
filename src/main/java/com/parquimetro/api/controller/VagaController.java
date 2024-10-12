package com.parquimetro.api.controller;

import com.parquimetro.api.dto.CreatedEntityIdDTO;
import com.parquimetro.api.dto.VagaDTO;
import com.parquimetro.api.entitys.Vaga;
import com.parquimetro.api.services.VagaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    private final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @PostMapping
    public ResponseEntity<CreatedEntityIdDTO> cadastrarVaga(@Valid @RequestBody VagaDTO vagaDTO) {
        var idCadastrado = vagaService.cadastrarVaga(vagaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreatedEntityIdDTO(idCadastrado));
    }

    @GetMapping
    public ResponseEntity<List<Vaga>> listarVagasDisponiveis() {
        var page = vagaService.listarVagasDisponveis();
        return ResponseEntity.ok(page);
    }

}