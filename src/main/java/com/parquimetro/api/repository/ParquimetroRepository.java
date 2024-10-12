package com.parquimetro.api.repository;

import com.parquimetro.api.model.Parquimetro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParquimetroRepository extends JpaRepository<Parquimetro, Long> {

}
