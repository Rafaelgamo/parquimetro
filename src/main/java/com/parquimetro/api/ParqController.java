package com.parquimetro.api;


import com.parquimetro.api.dto.DadosCadastro;
import com.parquimetro.api.dto.ListaVeiculos;
import com.parquimetro.api.repository.CadastroRepository;
import com.parquimetro.api.dto.Cadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/parquimetro_api")
public class ParqController {

    @Autowired
    private CadastroRepository repository;

    @PostMapping
    @Transactional
    public void cadastroEstacionar(@RequestBody DadosCadastro dados) {
        repository.save(new Cadastro(dados));
    }

    @GetMapping
        public Page<ListaVeiculos> listar(@PageableDefault(size = 10, sort ={"placa"}) Pageable paginacao){
            return repository.findAll(paginacao).map(ListaVeiculos::new);
        }
    }

