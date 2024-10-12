package com.parquimetro.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name ="vaga")
@Entity(name = "Vaga")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_parquimetro")
    @ManyToOne(targetEntity = Parquimetro.class, fetch = FetchType.LAZY)
    private Parquimetro parquimetro;

    private Boolean ocupada;

    public Vaga(Long id, Parquimetro parquimetro, Boolean ocupada) {
        this.id = id;
        this.parquimetro = parquimetro;
        this.ocupada = ocupada;
    }

    public Vaga() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Parquimetro getParquimetro() {
        return parquimetro;
    }

    public void setParquimetro(Parquimetro parquimetro) {
        this.parquimetro = parquimetro;
    }

    public Boolean getOcupada() {
        return ocupada;
    }

    public void setOcupada(Boolean ocupada) {
        this.ocupada = ocupada;
    }
}



