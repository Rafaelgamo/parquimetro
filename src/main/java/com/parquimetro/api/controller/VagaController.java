package com.parquimetro.api.controller;

import com.parquimetro.api.dto.CreatedEntityIdDTO;
import com.parquimetro.api.dto.VagaDTO;
import com.parquimetro.api.service.VagaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vagas")
@Tag(name = "vagas", description = "Gerir vagas")
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

    @GetMapping("/disponiveis/{idParquimetro}")
    public ResponseEntity<List<Long>> idsVagasDisponiveisPorParquinetro(@PathVariable("idParquimetro") Long idParquimetro) {
        var vagasDisponiveis = vagaService.buscarIdsDisponiveisPorParquimetro(idParquimetro);
        return ResponseEntity.ok(vagasDisponiveis);
    }

    @DeleteMapping("/{idVaga}")
    public ResponseEntity<Void> excluirVaga(@PathVariable("idVaga") Long idVaga) {
        vagaService.excluirVaga(idVaga);
        return ResponseEntity.noContent().build();
    }

}