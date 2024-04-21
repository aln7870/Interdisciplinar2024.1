package com.api.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Intrutor")
public class InstrutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cod_Instrutor")
    private Integer codInstrutor;

    @Column(name = "Nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "Sobrenome", length = 100, nullable = false)
    private String sobrenome;

    @Column(name = "Data_De_Nasc", nullable = false)
    private Date dataNasc;

    @Column(name = "Status", columnDefinition = "CHAR(1) DEFAULT 'A'")
    private char status;


    public Integer getCodInstrutor() {
        return codInstrutor;
    }

    public void setCodInstrutor(Integer codInstrutor) {
        this.codInstrutor = codInstrutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

}
