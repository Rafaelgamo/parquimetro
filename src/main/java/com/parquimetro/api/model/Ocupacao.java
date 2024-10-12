package com.parquimetro.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name ="ocupacao")
@Entity(name = "Ocupacao")
public class Ocupacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_vaga")
    @ManyToOne(targetEntity = Vaga.class, fetch = FetchType.LAZY)
    private Vaga vaga;

    @JoinColumn(name = "id_veiculo")
    @ManyToOne(targetEntity = Veiculo.class, fetch = FetchType.LAZY)
    private Veiculo veiculo;

    private Float tarifaAplicada;
    private Integer minutosReservados;
    private Float valorEmReais;

    private LocalDateTime horarioEntrada;
    private LocalDateTime horarioSaida;

    public Ocupacao(Long id, Vaga vaga, Veiculo veiculo, Float tarifaAplicada, Integer minutosReservados, Float valorEmReais, LocalDateTime horarioEntrada, LocalDateTime horarioSaida) {
        this.id = id;
        this.vaga = vaga;
        this.veiculo = veiculo;
        this.tarifaAplicada = tarifaAplicada;
        this.minutosReservados = minutosReservados;
        this.valorEmReais = valorEmReais;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
    }

    public Ocupacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Float getTarifaAplicada() {
        return tarifaAplicada;
    }

    public void setTarifaAplicada(Float tarifaAplicada) {
        this.tarifaAplicada = tarifaAplicada;
    }

    public Integer getMinutosReservados() {
        return minutosReservados;
    }

    public void setMinutosReservados(Integer minutosReservados) {
        this.minutosReservados = minutosReservados;
    }

    public Float getValorEmReais() {
        return valorEmReais;
    }

    public void setValorEmReais(Float valorEmReais) {
        this.valorEmReais = valorEmReais;
    }

    public LocalDateTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(LocalDateTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public LocalDateTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalDateTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

}