package com.parquimetro.api.controller;

import com.parquimetro.api.dto.*;
import com.parquimetro.api.services.OcupacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(name ="/tb_ocupacao")
public class OcupacaoController {


    private final OcupacaoService ocupacaoService;
    /* contrutor */
    public OcupacaoController(OcupacaoService ocupacaoService) {
        this.ocupacaoService = ocupacaoService;
    }

    @PostMapping /*mapeia  o metodo post, que recebe dados do cadastro*/
    @Transactional /* transição com banco e dados */
    public ResponseEntity cadastroOcupacao(@RequestBody OcupacaoDTO dados, UriComponentsBuilder uriBuilder) { /* Recebe dos dados para salvar */
        var ocupacao = ocupacaoService.ocuparVaga(dados);
        var uri = uriBuilder.path("/tb_ocupacao/{id}").buildAndExpand(ocupacao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoOcupacaoDTO(ocupacao));
    }

    }


