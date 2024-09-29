package com.parquimetro.api.controller;


import com.parquimetro.api.dto.ConsultaValor;
import com.parquimetro.api.dto.DadosCadastroVeiculos;
import com.parquimetro.api.dto.ConsultaVeiculos;
import com.parquimetro.api.repository.CadastroRepository;
import com.parquimetro.api.entitys.Veiculos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/parquimetro_api")
public class ParqController {

    @Autowired /* */
    private CadastroRepository repository;  /*vincula as bibliotecas do jpa, que esta como abstrato em interface */

    @PostMapping /*mapeia  o metodo post, que recebe dados do cadastro*/
    @Transactional /* transição com banco e dados */
    public void cadastroEstacionar(@RequestBody DadosCadastroVeiculos dados) { /* Recebe dos dados para salvar */
        repository.save(new Veiculos(dados));

    }
    @GetMapping  /* identifica metodo consultadar dados do banco */
    public ResponseEntity<Page<ConsultaVeiculos>> listar(@PageableDefault(size = 10, sort ={"placa"}) Pageable paginacao){  /* mapeia  para mostrar paginação  e consultadar dados do banco*/
        var page = repository.findAll(paginacao).map(ConsultaVeiculos::new);
        return ResponseEntity.ok(page);
    }

    public void valores(ConsultaValor dados){

    }

}




