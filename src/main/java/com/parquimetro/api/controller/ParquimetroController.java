package com.parquimetro.api.controller;

import com.parquimetro.api.dto.CreatedEntityIdDTO;
import com.parquimetro.api.dto.ParquimetroDTO;
import com.parquimetro.api.services.ParquimetroService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parquimetros")
public class ParquimetroController {

    private final ParquimetroService parquimetroService;

    public ParquimetroController(ParquimetroService parquimetroService) {
        this.parquimetroService = parquimetroService;
    }

    @PostMapping
    public ResponseEntity<CreatedEntityIdDTO> cadastroParquimetro(@Valid @RequestBody ParquimetroDTO dados) {
        var idCadastrado = parquimetroService.cadastrarParquimetro(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreatedEntityIdDTO(idCadastrado));
    }

    @GetMapping
    public ResponseEntity<Page<ParquimetroDTO>> listarParquimetros(@PageableDefault(size = 10) Pageable paginacao) {
        var page = parquimetroService.listarTodos(paginacao);
        return ResponseEntity.ok(page);
    }
}