package com.api.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "pix")
public class PixModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cod_Pix")
    private Long codPix;

    @Column(name = "Chave_Pix", nullable = false, length = 100)
    private String chavePix;

    @Column(name = "Valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "Data_Transacao", nullable = false)
    private Date dataTransacao;

    @Column(name = "Status", length = 1, columnDefinition = "CHAR DEFAULT 'P'")
    private char status;

    @Column(name = "Fk_Cod_Pagamento")
    private Long fkCodPagamento;

    @Column(name = "Fk_Cod_Aluno")
    private Long fkCodAluno;

    public Long getCodPix() {
        return codPix;
    }

    public void setCodPix(Long codPix) {
        this.codPix = codPix;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Long getFkCodPagamento() {
        return fkCodPagamento;
    }

    public void setFkCodPagamento(Long fkCodPagamento) {
        this.fkCodPagamento = fkCodPagamento;
    }

    public Long getFkCodAluno() {
        return fkCodAluno;
    }

    public void setFkCodAluno(Long fkCodAluno) {
        this.fkCodAluno = fkCodAluno;
    }
}
