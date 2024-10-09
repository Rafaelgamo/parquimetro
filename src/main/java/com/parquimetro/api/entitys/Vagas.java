package com.parquimetro.api.entitys;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;


@Entity
@Table(name = "tb_vaga")
@EqualsAndHashCode(of = "id")
public class Vagas{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Boolean ocupada;



}
