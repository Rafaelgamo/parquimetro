package com.parquimetro.api.repository;


import com.parquimetro.api.model.Ocupacao;
import com.parquimetro.api.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OcupacaoRepository extends JpaRepository<Ocupacao, Long> {

    @Modifying
    @Query("update Ocupacao oc set oc.horarioSaida = ?1 where oc.vaga.id = ?2 and oc.veiculo.id = ?3")
    int atualizarHorarioDeSaida(LocalDateTime horarioSaida, Long idVaga, Long idVeiculo);

    List<Ocupacao> findAllByVeiculo(Veiculo veiculo);
}
