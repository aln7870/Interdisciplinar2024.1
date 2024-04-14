package com.api.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "aluno")
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno",nullable = false)
    private Long idStudent;

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

    @Column(name = "cod_usuario", nullable = false)
    private Long codUsuario;


    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
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

    public Long getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Long codUsuario) {
        this.codUsuario = codUsuario;
    }
}
