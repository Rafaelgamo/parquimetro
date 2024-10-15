package com.parquimetro.api.repository;

import com.parquimetro.api.model.Parquimetro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParquimetroRepository extends JpaRepository<Parquimetro, Long> {

    boolean existsByEndereco(String endereco);

    @Modifying
    @Query("update Parquimetro p set p.valorTarifaAtual = ?2 where p.id = ?1")
    int alterarTarifa(Long idParquimetro, float novoValorTarifa);
}
