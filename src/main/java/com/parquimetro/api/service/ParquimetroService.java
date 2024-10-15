package com.parquimetro.api.service;

import com.parquimetro.api.dto.DetalhamentoParquimetroDTO;
import com.parquimetro.api.dto.ParquimetroDTO;
import com.parquimetro.api.infra.errors.exceptions.ErroDeValidacao;
import com.parquimetro.api.infra.errors.exceptions.RecursoNaoEncontrado;
import com.parquimetro.api.model.Parquimetro;
import com.parquimetro.api.repository.ParquimetroRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParquimetroService {

    private final ParquimetroRepository parquimetroRepository;
    private final VagaService vagaService;

    public ParquimetroService(ParquimetroRepository parquimetroRepository, @Lazy VagaService vagaService) {
        this.parquimetroRepository = parquimetroRepository;
        this.vagaService = vagaService;
    }

    @Transactional
    public Long cadastrarParquimetro(ParquimetroDTO dados) {
        var parquimetro = new Parquimetro();
        parquimetro.setValorTarifaAtual(dados.tarifaAtual());
        parquimetro.setEndereco(dados.endereco());

        boolean parquimetroCadastrado = parquimetroRepository.existsByEndereco(dados.endereco());
        if (parquimetroCadastrado) {
            throw new ErroDeValidacao("Parquimetro ja cadastrado com esse endereco");
        }

        var parquimetroSalvo = parquimetroRepository.save(parquimetro);
        return parquimetroSalvo.getId();
    }

    @Transactional(readOnly = true)
    public Page<ParquimetroDTO> listarTodos(Pageable paginacao) {
        return parquimetroRepository.findAll(paginacao).map(ParquimetroDTO::new);
    }

    @Transactional(readOnly = true)
    public boolean existePorId(Long idParquimetro) {
        return parquimetroRepository.existsById(idParquimetro);
    }

    @Transactional(readOnly = true)
    public DetalhamentoParquimetroDTO detalharParquimetro(Long idParquimetro) {
        var parquimetro = buscarPorId(idParquimetro);

        if (parquimetro == null) {
            throw new RecursoNaoEncontrado(Parquimetro.class, "id", idParquimetro);
        }

        var vagasDoParquimetro = vagaService.buscarIdsDisponiveisPorParquimetro(idParquimetro);

        return new DetalhamentoParquimetroDTO(parquimetro, vagasDoParquimetro);
    }

    @Transactional
    public void alterarTarifaParquimetro(Long idParquimetro, float novoValorTarifa) {
        boolean parquimetroExiste = parquimetroRepository.existsById(idParquimetro);
        if (!parquimetroExiste) {
            throw new RecursoNaoEncontrado(Parquimetro.class, "id", idParquimetro);
        }

        parquimetroRepository.alterarTarifa(idParquimetro, novoValorTarifa);
    }

    @Transactional
    public void excluirParquimetro(Long idParquimetro) {
        boolean parquimetroExiste = parquimetroRepository.existsById(idParquimetro);
        if (!parquimetroExiste) {
            throw new RecursoNaoEncontrado(Parquimetro.class, "id", idParquimetro);
        }

        parquimetroRepository.deleteById(idParquimetro);
    }

    public Parquimetro buscarPorId(Long idParquimetro) {
        return parquimetroRepository.findById(idParquimetro).orElse(null);
    }
}
