package com.api.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "matricula")
public class MatriculaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cod_matricula", nullable = false)
    private Long codMatricula;

    @Column(name = "Data_De_Matricula", nullable = false)
    private Date dataDeMatricula;

    @Column(name = "Duracao_contrato", length = 50)
    private String duracaoContrato;

    @Column(name = "valor_contrato", precision = 10, scale = 2)
    private BigDecimal valorContrato;

    @Column(name = "Status", length = 1, columnDefinition = "CHAR DEFAULT 'A'")
    private char status;

    @Column(name = "Cod_aluno", nullable = false)
    private Long fkidStudent;

    public Long getIdStudent() {
        return fkidStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.fkidStudent = idStudent;
    }

    public Long getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(Long codMatricula) {
        this.codMatricula = codMatricula;
    }

    public Date getDataDeMatricula() {
        return dataDeMatricula;
    }

    public void setDataDeMatricula(Date dataDeMatricula) {
        this.dataDeMatricula = dataDeMatricula;
    }

    public String getDuracaoContrato() {
        return duracaoContrato;
    }

    public void setDuracaoContrato(String duracaoContrato) {
        this.duracaoContrato = duracaoContrato;
    }

    public BigDecimal getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(BigDecimal valorContrato) {
        this.valorContrato = valorContrato;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

}