package com.api.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "turma")
public class TurmaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cod_turma", nullable = false)
    private Long codTurma;

    @Column(name = "NomeTurma", nullable = false, length = 100)
    private String nomeTurma;

    @Column(name = "Descricao", length = 255)
    private String descricao;

    @Column(name = "LimiteAlunos")
    private long limiteAlunos;

    @Column(name = "Local", length = 100)
    private String local;

    @Column(name = "DataInicio", nullable = false)
    private Date dataInicio;

    @Column(name = "DataTermino", nullable = false)
    private Date dataTermino;

    @Column(name = "status", columnDefinition = "CHAR(1) DEFAULT 'A'")
    private char status;

    @Column(name = "fk_Cod_Especialidade")
    private long fkEspecialidade;

    @Column(name = "fk_id_instrutor")
    private long idInstrutor;

    public Long getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(Long codTurma) {
        this.codTurma = codTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getLimiteAlunos() {
        return limiteAlunos;
    }

    public void setLimiteAlunos(long limiteAlunos) {
        this.limiteAlunos = limiteAlunos;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public long getFkEspecialidade() {
        return fkEspecialidade;
    }

    public void setFkEspecialidade(long fkEspecialidade) {
        this.fkEspecialidade = fkEspecialidade;
    }

    public long getIdInstrutor() {
        return idInstrutor;
    }

    public void setIdInstrutor(long idInstrutor) {
        this.idInstrutor = idInstrutor;
    }
}
