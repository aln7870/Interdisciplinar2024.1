package com.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "especialidade")
public class EspecialidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Especialidade", nullable = false)
    private Long idEspecialidade;

    @Column(name = "NomeEspecialidade", length = 100, nullable = false)
    private String nomeEspecialidade;

    @Column(name = "status", columnDefinition = "CHAR(1) DEFAULT 'A'")
    private char status;

    public Long getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Long idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
