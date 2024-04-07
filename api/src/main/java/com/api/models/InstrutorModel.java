package com.api.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "instrutor")
public class InstrutorModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cod_Instrutor", nullable = false)
    private Long codInstrutor;

    @Column(name = "Nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "Telefone", length = 15)
    private String telefone;

    @Column(name = "Horario_disponivel", length = 100)
    private String horarioDisponivel;

    @Column(name = "status", columnDefinition = "CHAR(1) DEFAULT 'A'")
    private char status;

    @Column(name = "FK_cod_Especialidade")
    private int fkCodEspecialidade;

    public Long getCodInstrutor() {
        return codInstrutor;
    }

    public void setCodInstrutor(Long codInstrutor) {
        this.codInstrutor = codInstrutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getHorarioDisponivel() {
        return horarioDisponivel;
    }

    public void setHorarioDisponivel(String horarioDisponivel) {
        this.horarioDisponivel = horarioDisponivel;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public int getFkCodEspecialidade() {
        return fkCodEspecialidade;
    }

    public void setFkCodEspecialidade(int fkCodEspecialidade) {
        this.fkCodEspecialidade = fkCodEspecialidade;
    }
}
