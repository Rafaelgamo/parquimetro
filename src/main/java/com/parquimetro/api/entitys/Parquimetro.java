package com.parquimetro.api.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name ="parquimetro")
@Entity(name = "Parquimetro")
public class Parquimetro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String endereco;
    private Float valorTarifaAtual;

    public Parquimetro(Long id, String endereco, Float valorTarifaAtual) {
        this.id = id;
        this.endereco = endereco;
        this.valorTarifaAtual = valorTarifaAtual;
    }

    public Parquimetro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String placa) {
        this.endereco = placa;
    }

    public Float getValorTarifaAtual() {
        return valorTarifaAtual;
    }

    public void setValorTarifaAtual(Float valorTarifaAtual) {
        this.valorTarifaAtual = valorTarifaAtual;
    }
}



