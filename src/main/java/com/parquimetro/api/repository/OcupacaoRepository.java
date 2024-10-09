package com.parquimetro.api.repository;


import com.parquimetro.api.entitys.Ocupacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcupacaoRepository extends JpaRepository<Ocupacao, Long> {



}
