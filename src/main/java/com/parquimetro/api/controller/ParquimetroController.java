package com.parquimetro.api.controller;

import com.parquimetro.api.dto.*;
import com.parquimetro.api.entitys.Parquimetros;
import com.parquimetro.api.repository.ParquimetrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("tb_parquimetros")
public class ParquimetroController {

    @Autowired /* */
    private ParquimetrosRepository parquimetrosRepository;  /*vincula as bibliotecas do jpa, que esta como abstrato em interface */

    @PostMapping /*mapeia  o metodo post, que recebe dados do cadastro*/
    @Transactional /* transição com banco e dados */
    public ResponseEntity cadastroParquimetro(@RequestBody ParquimetrosDTO dados, UriComponentsBuilder uriBuilder) { /* Recebe dos dados para salvar */
        var parquimetro = new Parquimetros(dados);
        parquimetrosRepository.save(parquimetro);
        var uri = uriBuilder.path("/tb_parquimetros/{id}").buildAndExpand(parquimetro.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoParquimetroDTO(parquimetro));
    }

    @GetMapping  /* id,  biuld deentifica metodo consultadar dados do banco */
    public ResponseEntity<Page<ConsultaParquimetroDTO>> listarParquimetros(@PageableDefault(size = 10, sort = {"endereco"}) Pageable paginacao) {  /* mapeia  para mostrar paginação  e consultadar dados do banco*/
        var page = parquimetrosRepository.findAll(paginacao).map(ConsultaParquimetroDTO::new);
        return ResponseEntity.ok(page);
    }
}