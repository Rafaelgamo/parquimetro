package com.parquimetro.api.services;


import com.parquimetro.api.dto.OcupacaoDTO;
import com.parquimetro.api.entitys.Ocupacao;
import com.parquimetro.api.entitys.Vagas;
import com.parquimetro.api.repository.OcupacaoRepository;
import com.parquimetro.api.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class VagaService {
        @Autowired
        private VagaRepository vagaRepository;

        public List<Vagas> listarVagasDisponveis() {
                return vagaRepository.findAllByOcupadaFalse();
        }
}