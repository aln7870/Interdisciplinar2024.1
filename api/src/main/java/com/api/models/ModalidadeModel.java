package com.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Modalidade")
public class ModalidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cod_Modalidade")
    private Integer codModalidade;

    @Column(name = "Nome_Modalidade")
    private String nomeModalidade;

    @Column(name = "status", columnDefinition = "CHAR(1) DEFAULT 'A'")
    private char status;

    public Integer getCodModalidade() {
        return codModalidade;
    }

    public void setCodModalidade(Integer codModalidade) {
        this.codModalidade = codModalidade;
    }

    public String getNomeModalidade() {
        return nomeModalidade;
    }

    public void setNomeModalidade(String nomeModalidade) {
        this.nomeModalidade = nomeModalidade;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

}
