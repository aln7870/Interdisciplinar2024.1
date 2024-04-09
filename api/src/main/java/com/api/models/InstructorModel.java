package com.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "instrutor")
public class InstructorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cod_Instrutor", nullable = false)
    private Long idInstructor;

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

    public Long getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstrutor(Long idInstructor) {
        this.idInstructor = idInstructor;
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
