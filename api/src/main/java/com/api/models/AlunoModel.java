package com.api.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "aluno")
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cod_Aluno", nullable = false)
    private Integer codAluno;

    @Column(name = "Nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "Sobrenome", length = 100)
    private String sobrenome;

    @Column(name = "Data_De_Nasc", nullable = false)
    private Date dataDeNascimento;


    @Column(name = "status", columnDefinition = "CHAR(1) DEFAULT 'A'")
    private char status;
    @OneToOne
    @JoinColumn(name = "Cod_Modalidade", referencedColumnName = "Cod_Modalidade")
    private ModalidadeModel fkModalidade;

    public ModalidadeModel getFkModalidade() {
        return fkModalidade;
    }

    public void setFkModalidade(ModalidadeModel fkModalidade) {
        this.fkModalidade = fkModalidade;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(Integer codAluno) {
        this.codAluno = codAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }


    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }


}