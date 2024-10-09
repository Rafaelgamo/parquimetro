package com.parquimetro.api.controller;

import com.parquimetro.api.dto.ConsultaOcupacaoDTO;
import com.parquimetro.api.dto.DetalhamentoOcupacaoDTO;
import com.parquimetro.api.dto.OcupacaoDTO;
import com.parquimetro.api.entitys.Vagas;
import com.parquimetro.api.repository.VagaRepository;
import com.parquimetro.api.services.OcupacaoService;
import com.parquimetro.api.services.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(name ="/vagas")
public class VagaController {
    @Autowired
    private VagaService vagaService;
    @GetMapping  /* id,  biuld deentifica metodo consultadar dados do banco */
    public ResponseEntity<List<Vagas>> listarOcupacao(@PageableDefault(size = 10, sort = {"entrada"}) Pageable paginacao) {  /* mapeia  para mostrar paginação  e consultadar dados do banco*/

        var page = vagaService.listarVagasDisponveis();
        return ResponseEntity.ok(page);
    }
}

