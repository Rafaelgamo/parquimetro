package com.parquimetro.api.repository;

import com.parquimetro.api.entitys.Parquimetros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParquimetrosRepository extends JpaRepository<Parquimetros, Long> {

}
