package com.parquimetro.api.controller;

import com.parquimetro.api.dto.AlterarTarifaParquimetroDTO;
import com.parquimetro.api.dto.CreatedEntityIdDTO;
import com.parquimetro.api.dto.DetalhamentoParquimetroDTO;
import com.parquimetro.api.dto.ParquimetroDTO;
import com.parquimetro.api.service.ParquimetroService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parquimetros")
@Tag(name = "parquimetros", description = "Gerir parquimetros")
public class ParquimetroController {

    private final ParquimetroService parquimetroService;

    public ParquimetroController(ParquimetroService parquimetroService) {
        this.parquimetroService = parquimetroService;
    }

    @GetMapping("/{idParquimetro}")
    public ResponseEntity<DetalhamentoParquimetroDTO> detalharParquimetro(@PathVariable("idParquimetro") Long idParquimetro) {
        var detalhamentoParquimetroDTO = parquimetroService.detalharParquimetro(idParquimetro);
        return ResponseEntity.ok(detalhamentoParquimetroDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ParquimetroDTO>> listarParquimetros(@PageableDefault(size = 10) Pageable paginacao) {
        var page = parquimetroService.listarTodos(paginacao);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    public ResponseEntity<CreatedEntityIdDTO> cadastroParquimetro(@Valid @RequestBody ParquimetroDTO dados) {
        var idCadastrado = parquimetroService.cadastrarParquimetro(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreatedEntityIdDTO(idCadastrado));
    }

    @PutMapping()
    public ResponseEntity<Void> alterarTarifaParquimetro(@Valid @RequestBody AlterarTarifaParquimetroDTO alterarTarifaParquimetroDTO) {
        parquimetroService.alterarTarifaParquimetro(
                alterarTarifaParquimetroDTO.idParquimetro(),
                alterarTarifaParquimetroDTO.novoValorTarifa()
        );

        return ResponseEntity.noContent().build();
    }
}