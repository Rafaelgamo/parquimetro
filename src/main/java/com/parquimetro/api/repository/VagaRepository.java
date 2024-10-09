package com.parquimetro.api.repository;


import com.parquimetro.api.entitys.Ocupacao;
import com.parquimetro.api.entitys.Vagas;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VagaRepository extends JpaRepository<Vagas, Long> {

    List<Vagas> findAllByOcupadaFalse();


}
