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
@RequestMapping ("tb_veiculos")
public class VeiculosController {

    @Autowired /* */
    private VeiculosRepository repository;  /*vincula as bibliotecas do jpa, que esta como abstrato em interface */

    @PostMapping /*mapeia  o metodo post, que recebe dados do cadastro*/
    @Transactional /* transição com banco e dados */
    public ResponseEntity cadastroEstacionar(@RequestBody VeiculosDTO dados, UriComponentsBuilder uriBuilder) { /* Recebe dos dados para salvar */
        var veiculo = new Veiculos(dados);
        repository.save(veiculo);
        var uri = uriBuilder.path("/tb_veiculos/{id}").buildAndExpand(veiculo.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoVeiculoDTO(veiculo));
    }

   @GetMapping  /* id,  biuld deentifica metodo consultadar dados do banco */
    public ResponseEntity<Page<ConsultaVeiculosDTO>> listar(@PageableDefault(size = 10, sort = {"placa"}) Pageable paginacao) {  /* mapeia  para mostrar paginação  e consultadar dados do banco*/
        var page = repository.findAll(paginacao).map(ConsultaVeiculosDTO::new);
        return ResponseEntity.ok(page);
    }
}


