package com.parquimetro.api.services;


import com.parquimetro.api.entitys.Vaga;
import com.parquimetro.api.repository.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {

    private final VagaRepository vagaRepository;

    public VagaService(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    public List<Vaga> listarVagasDisponveis() {
        return vagaRepository.findAllByOcupadaFalse();
    }
}