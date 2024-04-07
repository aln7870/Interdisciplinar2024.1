package com.api.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "aluno")
public class AlunoModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno",nullable = false)
    private Long idAluno;

    @Column(name = "Nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "Data_inicio", nullable = false)
    private Date dataInicio;

    @Column(name = "Observacoes", length = 255)
    private String observacoes;

    @Column(name = "status", columnDefinition = "CHAR(1) DEFAULT 'A'")
    private char status;

    @Column(name = "status_de_pagamentos", columnDefinition = "CHAR(1) DEFAULT 'A'")
    private char statusDePagamento;

    @Column(name = "NivelCondicionamento", length = 50)
    private String nivelCondicionamento;

    @Column(name = "ObjetivoTreino", length = 255)
    private String objetivoTreino;

    @Column(name = "AvaliacaoFisica", length = 255)
    private String avaliacaoFisica;

    @Column(name = "UltimaAtualizacao", length = 100)
    private String ultimaAtualizacao;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;


    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public char getStatusDePagamento() {
        return statusDePagamento;
    }

    public void setStatusDePagamento(char statusDePagamento) {
        this.statusDePagamento = statusDePagamento;
    }

    public String getNivelCondicionamento() {
        return nivelCondicionamento;
    }

    public void setNivelCondicionamento(String nivelCondicionamento) {
        this.nivelCondicionamento = nivelCondicionamento;
    }

    public String getObjetivoTreino() {
        return objetivoTreino;
    }

    public void setObjetivoTreino(String objetivoTreino) {
        this.objetivoTreino = objetivoTreino;
    }

    public String getAvaliacaoFisica() {
        return avaliacaoFisica;
    }

    public void setAvaliacaoFisica(String avaliacaoFisica) {
        this.avaliacaoFisica = avaliacaoFisica;
    }

    public String getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(String ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
