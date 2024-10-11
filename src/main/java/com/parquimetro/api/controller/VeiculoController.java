package com.parquimetro.api.controller;


import com.parquimetro.api.dto.*;
import com.parquimetro.api.repository.VeiculosRepository;
import com.parquimetro.api.entitys.Veiculos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping ("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculosRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastroEstacionar(@RequestBody VeiculosDTO dados, UriComponentsBuilder uriBuilder) {
        var veiculo = new Veiculos(dados);
        repository.save(veiculo);
        var uri = uriBuilder.path("/tb_veiculos/{id}").buildAndExpand(veiculo).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoVeiculoDTO(veiculo));
    }

   @GetMapping
    public ResponseEntity<Page<ConsultaVeiculosDTO>> listar(@PageableDefault(size = 10, sort = {"placa"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(ConsultaVeiculosDTO::new);
        return ResponseEntity.ok(page);
    }

}