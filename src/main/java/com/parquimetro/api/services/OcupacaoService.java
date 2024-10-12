package com.parquimetro.api.services;


import com.parquimetro.api.dto.OcuparVagaDTO;
import com.parquimetro.api.entitys.Ocupacao;
import com.parquimetro.api.repository.OcupacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcupacaoService {

    @Autowired
    private OcupacaoRepository ocupacaoRepository;

    @Transactional
    public Ocupacao ocuparVaga(OcuparVagaDTO ocuparVagaDTO){

        /* metodo ocupacaoRepositoryByVaga
         * verificar se vaga esta ocupada
         * */
        var resto = ocuparVagaDTO.permanencia() % 15;
        if(resto != 0 || ocuparVagaDTO.permanencia() > 120){ /* % resto */
            throw  new RuntimeException (" Tempo invalido");

        }
        var ocupacao = new Ocupacao();
        /*ocupacao.setEntrada(LocalTime.now());
        ocupacao.setPermanecia(ocupacaoDTO.permanencia());
        ocupacao.setValor(ocupacao.getPermanecia() * ocupacao.getValor()/ 15);*/
        return ocupacaoRepository.save(ocupacao);
    }


    // checar ocupaçççç

}