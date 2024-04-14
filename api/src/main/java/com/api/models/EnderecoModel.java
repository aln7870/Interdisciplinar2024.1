package com.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cod_Endereco", nullable = false)
    private Long codEndereco;

    @Column(name = "Rua", nullable = false, length = 100)
    private String rua;

    @Column(name = "Numero", nullable = false)
    private Long numero;

    @Column(name = "Complemento", length = 100)
    private String complemento;

    @Column(name = "Bairro", length = 100)
    private String bairro;

    @Column(name = "Cidade", length = 100)
    private String cidade;

    @Column(name = "Cep")
    private Long cep;

    @Column(name = "status", length = 1, columnDefinition = "CHAR DEFAULT 'A'")
    private char status = 'A';

    @Column(name = "Fk_Cod_Usuario", nullable = false)
    private Long fkCodUsuario;

    public Long getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(Long codEndereco) {
        this.codEndereco = codEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Long getFkCodUsuario() {
        return fkCodUsuario;
    }

    public void setFkCodUsuario(Long fkCodUsuario) {
        this.fkCodUsuario = fkCodUsuario;
    }
}
