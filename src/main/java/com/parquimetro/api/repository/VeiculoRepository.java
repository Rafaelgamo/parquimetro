package com.parquimetro.api.repository;

import com.parquimetro.api.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    Optional<Veiculo> findByPlaca(String placaVeiculo);

    boolean existsByPlaca(String placa);

    @Query("select v.id from Veiculo v where v.placa = ?1")
    Optional<Long> buscarIdPelaPlaca(String placa);
}