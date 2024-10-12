package com.parquimetro.api.services;


import com.parquimetro.api.dto.VagaDTO;
import com.parquimetro.api.entitys.Parquimetro;
import com.parquimetro.api.entitys.Vaga;
import com.parquimetro.api.repository.VagaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VagaService {

    private final VagaRepository vagaRepository;
    private final ParquimetroService parquimetroService;

    public VagaService(VagaRepository vagaRepository, ParquimetroService parquimetroService) {
        this.vagaRepository = vagaRepository;
        this.parquimetroService = parquimetroService;
    }

    @Transactional(readOnly = true)
    public List<Vaga> listarVagasDisponveis() {
        return vagaRepository.findAllByOcupadaFalse();
    }

    @Transactional
    public boolean verificarOcupacao(Long idVaga) {
        var vaga = vagaRepository.findById(idVaga);

        if (vaga.isEmpty()) {
            throw new RuntimeException("Vaga nao existe pelo id: " + idVaga);
        }

        return vaga.get().getOcupada();
    }

    @Transactional
    public Long cadastrarVaga(VagaDTO vagaDTO) {
        var vaga = new Vaga();

        var idParquimetro = vagaDTO.idParquimetro();
        boolean parquimetroExiste = parquimetroService.existePorId(idParquimetro);
        if (!parquimetroExiste) {
            throw new RuntimeException("Parquimetro especificado nao existe");
        }

        var parquimetro = new Parquimetro();
        parquimetro.setId(idParquimetro);

        vaga.setParquimetro(parquimetro);

        var vagaSalva = vagaRepository.save(vaga);
        return vagaSalva.getId();
    }

}