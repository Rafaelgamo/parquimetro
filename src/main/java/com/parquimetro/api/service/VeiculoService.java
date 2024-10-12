package com.parquimetro.api.service;

import com.parquimetro.api.dto.VeiculoDTO;
import com.parquimetro.api.model.Veiculo;
import com.parquimetro.api.repository.VeiculoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Transactional
    public Long cadastrarVeiculo(VeiculoDTO dados) {
        var veiculo = new Veiculo();
        veiculo.setPlaca(dados.placa());
        veiculo.setModelo(dados.modelo());
        veiculo.setAnoFabricacao(dados.anoFabricacao());

        var veiculoSalvo = veiculoRepository.save(veiculo);
        if (veiculoSalvo == null) {
            throw new RuntimeException("Erro ao cadastrar veiculo");
        }
        return veiculoSalvo.getId();
    }

    @Transactional(readOnly = true)
    public Page<VeiculoDTO> listarTodos(Pageable paginacao) {
        return veiculoRepository.findAll(paginacao).map(VeiculoDTO::new);
    }

    @Transactional(readOnly = true)
    public boolean existePorId(Long idVeiculo) {
        return veiculoRepository.existsById(idVeiculo);
    }

    @Transactional
    public Veiculo buscarPorId(Long idVeiculo) {
        return veiculoRepository.findById(idVeiculo).orElse(null);
    }

    public Veiculo buscarPelaPlaca(String placaVeiculo) {
        return veiculoRepository.findByPlaca(placaVeiculo).orElse(null);
    }
}
