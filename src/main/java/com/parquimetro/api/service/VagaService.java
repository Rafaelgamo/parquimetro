package com.parquimetro.api.service;


import com.parquimetro.api.dto.VagaDTO;
import com.parquimetro.api.infra.errors.exceptions.ErroDeValidacao;
import com.parquimetro.api.infra.errors.exceptions.RecursoNaoEncontrado;
import com.parquimetro.api.model.Parquimetro;
import com.parquimetro.api.model.Vaga;
import com.parquimetro.api.repository.VagaRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VagaService {

    private final VagaRepository vagaRepository;
    private final ParquimetroService parquimetroService;

    public VagaService(VagaRepository vagaRepository, @Lazy ParquimetroService parquimetroService) {
        this.vagaRepository = vagaRepository;
        this.parquimetroService = parquimetroService;
    }

    @Transactional(readOnly = true)
    public Vaga buscarPorId(Long idVaga) {
        var entidade = vagaRepository.findById(idVaga).orElse(null);
        return entidade;
    }

    @Transactional(readOnly = true)
    public List<VagaDTO> listarVagasDisponveis() {
        return vagaRepository.findAllByOcupadaFalse()
                .stream()
                .map(VagaDTO::new)
                .toList();
    }

    @Transactional
    public boolean verificarOcupacao(Long idVaga) {
        var vaga = vagaRepository.findById(idVaga);

        if (vaga.isEmpty()) {
            throw new ErroDeValidacao("Vaga nao existe pelo id: " + idVaga);
        }

        return vaga.get().getOcupada();
    }

    @Transactional
    public Long cadastrarVaga(VagaDTO vagaDTO) {
        var idParquimetro = vagaDTO.idParquimetro();

        boolean parquimetroExiste = parquimetroService.existePorId(idParquimetro);
        if (!parquimetroExiste) {
            throw new ErroDeValidacao("Parquimetro especificado nao existe");
        }

        var parquimetro = new Parquimetro();
        parquimetro.setId(idParquimetro);

        var vaga = new Vaga();
        vaga.setParquimetro(parquimetro);

        var vagaSalva = vagaRepository.save(vaga);
        return vagaSalva.getId();
    }

    @Transactional
    public void liberarVaga(Long idVaga) {
        vagaRepository.liberarVaga(idVaga);
    }

    @Transactional(readOnly = true)
    public List<Long> buscarIdsDisponiveisPorParquimetro(Long idParquimetro) {
        return vagaRepository.listarVagasDisponiveisPorParquimetro(idParquimetro);
    }

    @Transactional
    public void excluirVaga(Long idVaga) {
        boolean vagaExiste = vagaRepository.existsById(idVaga);
        if (!vagaExiste) {
            throw new RecursoNaoEncontrado(Vaga.class, "id", idVaga);
        }

        vagaRepository.deleteById(idVaga);
    }
}