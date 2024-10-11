package com.parquimetro.api.repository;

import com.parquimetro.api.entitys.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {

    }


