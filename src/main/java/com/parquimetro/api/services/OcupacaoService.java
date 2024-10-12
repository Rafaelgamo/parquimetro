package com.parquimetro.api.services;


import com.parquimetro.api.dto.LiberarVagaDTO;
import com.parquimetro.api.dto.OcupacaoDTO;
import com.parquimetro.api.dto.OcuparVagaDTO;
import com.parquimetro.api.entitys.Ocupacao;
import com.parquimetro.api.repository.OcupacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OcupacaoService {

    private final OcupacaoRepository ocupacaoRepository;
    private final VagaService vagaService;
    private final VeiculoService veiculoService;

    public OcupacaoService(OcupacaoRepository ocupacaoRepository, VagaService vagaService, VeiculoService veiculoService) {
        this.ocupacaoRepository = ocupacaoRepository;
        this.vagaService = vagaService;
        this.veiculoService = veiculoService;
    }

    @Transactional
    public OcupacaoDTO ocuparVaga(OcuparVagaDTO ocuparVagaDTO) {
        var idVaga = ocuparVagaDTO.idVaga();
        var tempoRequisitado = ocuparVagaDTO.tempoEmMinutos();
        var idVeiculo = ocuparVagaDTO.idVeiculo();

        var tempoRequisitadoEhValido = tempoRequisitado % 15 == 0
                && tempoRequisitado >= 15
                && tempoRequisitado <= 120;
        if (!tempoRequisitadoEhValido) {
            throw new RuntimeException ("Tempo Invalido para reserva... Opcoes de tempo para reservar (em minutos): 15, 30, 45, 60, 75, 90, 105, 120");
        }

        var vaga = vagaService.buscarPorId(idVaga);
        if (vaga == null) {
            throw new RuntimeException("Vaga nao encontrada...");
        }

        var vagaJaOcupada = vaga.getOcupada();
        if (vagaJaOcupada) {
            throw new RuntimeException("Vaga ja ocupada, tente listar as vagas disponiveis em: /parquimetros/[id_parquimetro]");
        }

        var veiculo = veiculoService.buscarPorId(idVeiculo);
        if (veiculo == null) {
            throw new RuntimeException("Vaga nao cadastrado, cadastre primeiro em: POST - /veiculos");
        }

        var parquimetroControlador = vaga.getParquimetro();
        var tarifaAtualParquimetro = parquimetroControlador.getValorTarifaAtual();

        var valorDaReserva = tarifaAtualParquimetro * ((float) tempoRequisitado / 15);

        var ocupacao = new Ocupacao();
        ocupacao.setHorarioEntrada(LocalDateTime.now());
        ocupacao.setMinutosReservados(tempoRequisitado);
        ocupacao.setValorEmReais(valorDaReserva);
        ocupacao.setTarifaAplicada(tarifaAtualParquimetro);

        ocupacao.setVaga(vaga);
        ocupacao.setVeiculo(veiculo);

        var ocupacaoSalva = ocupacaoRepository.save(ocupacao);

        vaga.setOcupada(Boolean.TRUE);

        return new OcupacaoDTO(ocupacaoSalva);
    }

    @Transactional
    public void liberarVaga(LiberarVagaDTO liberarVagaDTO) {
        var idVaga = liberarVagaDTO.idVaga();
        var idVeiculo = liberarVagaDTO.idVeiculo();

        ocupacaoRepository.atualizarHorarioDeSaida(LocalDateTime.now(), idVaga, idVeiculo);
        vagaService.liberarVaga(idVaga);
    }
}