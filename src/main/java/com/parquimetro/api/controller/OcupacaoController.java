package com.parquimetro.api.controller;

import com.parquimetro.api.dto.LiberarVagaDTO;
import com.parquimetro.api.dto.OcupacaoDTO;
import com.parquimetro.api.dto.OcuparVagaDTO;
import com.parquimetro.api.service.OcupacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OcupacaoController {

    private final OcupacaoService ocupacaoService;

    public OcupacaoController(OcupacaoService ocupacaoService) {
        this.ocupacaoService = ocupacaoService;
    }


    @PostMapping("/solicitar-ocupacao")
    public ResponseEntity<OcupacaoDTO> cadastroOcupacao(@Valid @RequestBody OcuparVagaDTO ocuparVagaDTO) {
        var ocupacao = ocupacaoService.ocuparVaga(ocuparVagaDTO);
        return ResponseEntity.ok(ocupacao);
    }

    @PostMapping("/liberar-vaga")
    public ResponseEntity<Void> liberarVaga(@Valid @RequestBody LiberarVagaDTO liberarVagaDTO) {
        ocupacaoService.liberarVaga(liberarVagaDTO);
        return ResponseEntity.ok().build();
    }

}