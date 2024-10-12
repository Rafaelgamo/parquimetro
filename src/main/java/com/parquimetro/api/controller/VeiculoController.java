package com.parquimetro.api.controller;


import com.parquimetro.api.dto.CreatedEntityIdDTO;
import com.parquimetro.api.dto.VeiculoDTO;
import com.parquimetro.api.services.VeiculoService;
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
@RequestMapping ("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<CreatedEntityIdDTO> cadastroEstacionar(@RequestBody VeiculoDTO dados) {
        var idCadastrado = veiculoService.cadastrarVeiculo(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreatedEntityIdDTO(idCadastrado));
    }

   @GetMapping
    public ResponseEntity<Page<VeiculoDTO>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = veiculoService.listarTodos(paginacao);
        return ResponseEntity.ok(page);
    }

}