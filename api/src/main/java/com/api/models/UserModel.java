package com.api.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "usuario")
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Cod_Usuario")
    private UUID idUser;
    //nullable = false == not null
    @Column(name = "Nome", nullable = false, length = 100)
    private String name;
    @Column(name = "Email", nullable = false, length = 100)
    private String email;
    @Column(name = "Senha", nullable = false, length = 50)
    private String senha;
    @Column(name = "Telefone", nullable = false, length = 15)
    private String telefone;
    @Column(name = "Data_De_Nasc", nullable = false)
    //date recebe tipo "yyyy-MM-dd"
    private Date dataNasc;
    @Column(name = "Genero", nullable = false, length = 10)
    private String genero;
    @Column(name = "Tip_usuario", nullable = false, length = 15)
    //tipo usuario
    // muai thai = 1/ boxe = 2/ jiu jitsu = 3/ cross fit = 4
    private String modalidade;
    @Column(name = "Status", columnDefinition = "CHAR(1) DEFAULT 'A'")
    private char status;
    @Column(name = "Fk_Cod_matricula")
    private int fkCodMatricula;
    @Column(name = "Fk_Cod_Instrutor")
    private int fkCodInstrutor;


    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public int getFkCodMatricula() {
        return fkCodMatricula;
    }

    public void setFkCodMatricula(int fkCodMatricula) {
        this.fkCodMatricula = fkCodMatricula;
    }

    public int getFkCodInstrutor() {
        return fkCodInstrutor;
    }

    public void setFkCodInstrutor(int fkCodInstrutor) {
        this.fkCodInstrutor = fkCodInstrutor;
    }
}