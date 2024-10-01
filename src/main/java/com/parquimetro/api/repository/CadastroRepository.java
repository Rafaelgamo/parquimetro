package com.parquimetro.api.repository;

import com.parquimetro.api.entitys.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import java.util.Optional;

@EnableSpringDataWebSupport
public interface CadastroRepository extends JpaRepository<Veiculos, Long> {



    }


