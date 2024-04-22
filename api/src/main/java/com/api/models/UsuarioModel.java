package com.api.models;

import jakarta.persistence.*;


import java.sql.Date;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //updatable = false == é para quando atualizar uma entidade usuario o valor do campo 'idUser' não será alterado no banco
    @Column(name = "Cod_Usuario", nullable = false)
    private Integer idUser;
    //nullable = false == not null
    @Column(name = "Nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "Email", nullable = false, length = 100)
    private String email;

    @Column(name = "Senha", nullable = false, length = 100)
    private String senha;

    @Column(name = "Telefone", nullable = false, length = 15)
    private String telefone;

    @Column(name = "Data_De_Nasc", nullable = false)
    //date recebe tipo "yyyy-MM-dd"
    private Date dataNasc;

    @Column(name = "Genero", nullable = false, length = 10)
    private String genero;

    @Column(name = "Status", columnDefinition = "CHAR(1) DEFAULT 'A'")
    private char status;

    @OneToOne
    @JoinColumn(name = "Cod_Aluno", referencedColumnName = "Cod_Aluno")
    private AlunoModel fkAluno;

    @OneToOne
    @JoinColumn(name = "Cod_Instrutor", referencedColumnName = "Cod_Instrutor")
    private InstrutorModel fkInstrutor;

    @OneToOne
    @JoinColumn(name = "Cod_Modalidade", referencedColumnName = "Cod_Modalidade")
    private ModalidadeModel fkModalidade;

    public ModalidadeModel getFkModalidade() {
        return fkModalidade;
    }

    public void setFkModalidade(ModalidadeModel fkModalidade) {
        this.fkModalidade = fkModalidade;
    }

    public AlunoModel getFkAluno() {
        return fkAluno;
    }

    public void setFkAluno(AlunoModel fkAluno) {
        this.fkAluno = fkAluno;
    }

    public InstrutorModel getFkInstrutor() {
        return fkInstrutor;
    }

    public void setFkInstrutor(InstrutorModel fkInstrutor) {
        this.fkInstrutor = fkInstrutor;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() { return senha; }

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

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }


}