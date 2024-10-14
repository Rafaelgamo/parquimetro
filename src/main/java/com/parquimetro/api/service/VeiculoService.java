package com.parquimetro.api.service;

import com.parquimetro.api.dto.VeiculoDTO;
import com.parquimetro.api.infra.errors.exceptions.EntidadeJaExiste;
import com.parquimetro.api.infra.errors.exceptions.ErroDeValidacao;
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
        var placa = dados.placa();
        var veiculo = new Veiculo();
        veiculo.setPlaca(placa);
        veiculo.setModelo(dados.modelo());
        veiculo.setAnoFabricacao(dados.anoFabricacao());

        boolean placaJaCadastrada = veiculoRepository.existsByPlaca(placa);
        if (placaJaCadastrada) {
            throw new EntidadeJaExiste(Veiculo.class, "placa", placa);
        }

        var veiculoSalvo = veiculoRepository.save(veiculo);
        if (veiculoSalvo == null) {
            throw new ErroDeValidacao("Erro ao cadastrar veiculo");
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

    @Transactional(readOnly = true)
    public Veiculo buscarPorId(Long idVeiculo) {
        return veiculoRepository.findById(idVeiculo).orElse(null);
    }

    @Transactional(readOnly = true)
    public Veiculo buscarPelaPlaca(String placaVeiculo) {
        return veiculoRepository.findByPlaca(placaVeiculo).orElse(null);
    }

    @Transactional(readOnly = true)
    public Long buscarIdPelaPlaca(String placa) {
        return veiculoRepository.buscarIdPelaPlaca(placa).orElse(null);
    }
}
