package com.parquimetro.api.services;


import com.parquimetro.api.dto.OcupacaoDTO;
import com.parquimetro.api.entitys.Ocupacao;
import com.parquimetro.api.repository.OcupacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class OcupacaoService {

        @Autowired
        private OcupacaoRepository ocupacaoRepository;

        public Ocupacao ocuparVaga(OcupacaoDTO ocupacaoDTO){

                /* metodo ocupacaoRepositoryByVaga
                * verificar se vaga esta ocupada
                *
                *
                *
                * */
                var resto = ocupacaoDTO.permanencia() % 15;
                if(resto != 0 || ocupacaoDTO.permanencia() > 120){ /* % resto */
                        throw  new RuntimeException (" Tempo invalido");

                }
                var Ocupacao = new Ocupacao();
                Ocupacao.setEntrada(LocalTime.now());
                Ocupacao.setPermanecia(ocupacaoDTO.permanencia());
                Ocupacao.setValor(Ocupacao.getPermanecia() * Ocupacao.getValor()/ 15);
                return ocupacaoRepository.save(Ocupacao);

        }



}