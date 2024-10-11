package com.parquimetro.api.controller;

import com.parquimetro.api.dto.DetalhamentoOcupacaoDTO;
import com.parquimetro.api.dto.OcupacaoDTO;
import com.parquimetro.api.services.OcupacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(name ="/ocupacao")
public class OcupacaoController {


    private final OcupacaoService ocupacaoService;

    public OcupacaoController(OcupacaoService ocupacaoService) {
        this.ocupacaoService = ocupacaoService;
    }

    @PostMapping
    public ResponseEntity cadastroOcupacao(@RequestBody OcupacaoDTO dados, UriComponentsBuilder uriBuilder) {
        var ocupacao = ocupacaoService.ocuparVaga(dados);
        var uri = uriBuilder.path("/tb_ocupacao/{id}").buildAndExpand(ocupacao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoOcupacaoDTO(ocupacao));
    }

}