package com.parquimetro.api.repository;


import com.parquimetro.api.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {

    List<Vaga> findAllByOcupadaFalse();

    @Modifying
    @Query("update Vaga v set v.ocupada = false where v.id = ?1")
    int liberarVaga(Long idVaga);

    @Query("select v.id " +
            "from Vaga v " +
            "where v.parquimetro.id = ?1 " +
            "   and v.ocupada = false")
    List<Long> listarVagasDisponiveisPorParquimetro(Long idParquimetro);
}