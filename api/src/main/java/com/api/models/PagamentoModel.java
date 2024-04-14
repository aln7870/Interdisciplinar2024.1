package com.api.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "pagamento")
public class PagamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cod_Pagamento", nullable = false)
    private Long codPagamento;

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
    private Long fkCodAluno;

    public Long getCodPagamento() {
        return codPagamento;
    }

    public void setCodPagamento(Long codPagamento) {
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

    public Long getFkCodAluno() {
        return fkCodAluno;
    }

    public void setFkCodAluno(Long fkCodAluno) {
        this.fkCodAluno = fkCodAluno;
    }
}
