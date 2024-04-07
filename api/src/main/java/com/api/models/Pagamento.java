package com.api.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cod_Pagamento")
    private Integer codPagamento;

    @Column(name = "Tipo_Pagamento", length = 50)
    private String tipoPagamento;

    @Column(name = "Valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "Data_Vencimento", nullable = false)
    private Date dataVencimento;

    @Column(name = "Data_Pagamento")
    private Date dataPagamento;

    @Column(name = "Status", length = 1, columnDefinition = "CHAR DEFAULT 'N'")
    private char status;

    @Column(name = "Fk_Cod_aluno", nullable = false)
    private Integer fkCodAluno;

    public Integer getCodPagamento() {
        return codPagamento;
    }

    public void setCodPagamento(Integer codPagamento) {
        this.codPagamento = codPagamento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Integer getFkCodAluno() {
        return fkCodAluno;
    }

    public void setFkCodAluno(Integer fkCodAluno) {
        this.fkCodAluno = fkCodAluno;
    }
}
