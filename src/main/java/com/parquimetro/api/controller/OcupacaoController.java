package com.parquimetro.api.controller;

import com.parquimetro.api.dto.HistoricoVeiculoDTO;
import com.parquimetro.api.dto.LiberarVagaDTO;
import com.parquimetro.api.dto.OcupacaoDTO;
import com.parquimetro.api.dto.OcuparVagaDTO;
import com.parquimetro.api.service.OcupacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "ocupacao", description = "Gerir ocupacoes")
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

    @Operation(description = "Lista o historico de vagas ocupadas por este veiculo")
    @GetMapping("/historico/{idVeiculo}")
    public ResponseEntity<HistoricoVeiculoDTO> listarHistoricoDoVeiculo(@PathVariable("idVeiculo") Long idVeiculo) {
        var historico = ocupacaoService.buscarHistoricoDoVeiculo(idVeiculo);
        return ResponseEntity.ok(historico);
    }

}