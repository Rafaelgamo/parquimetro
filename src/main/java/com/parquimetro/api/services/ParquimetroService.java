package com.parquimetro.api.services;

import com.parquimetro.api.dto.ParquimetroDTO;
import com.parquimetro.api.entitys.Parquimetro;
import com.parquimetro.api.repository.ParquimetroRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ParquimetroService {

    private final ParquimetroRepository parquimetroRepository;

    public ParquimetroService(ParquimetroRepository parquimetroRepository) {
        this.parquimetroRepository = parquimetroRepository;
    }

    @Transactional
    public Long cadastrarParquimetro(ParquimetroDTO dados) {
        var parquimetro = new Parquimetro();
        parquimetro.setValorTarifaAtual(dados.tarifaAtual());
        parquimetro.setEndereco(dados.endereco());

        var parquimetroSalvo = parquimetroRepository.save(parquimetro);
        if (parquimetroSalvo == null) {
            throw new RuntimeException("Falha ao cadastrar parquimetro...");
        }

        return parquimetroSalvo.getId();
    }

    @Transactional
    public Page<ParquimetroDTO> listarTodos(Pageable paginacao) {
        return parquimetroRepository.findAll(paginacao).map(ParquimetroDTO::new);
    }
}
