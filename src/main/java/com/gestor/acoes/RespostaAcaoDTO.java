package com.gestor.acoes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class RespostaAcaoDTO implements Serializable {

    private String nome;
    private LocalDate data;
    private BigDecimal valorAbertura;
    private BigDecimal valorFechamento;

    private String teste;

    public RespostaAcaoDTO(String nome, LocalDate data, BigDecimal valorAbertura, BigDecimal valorFechamento, String teste) {
        this.nome = nome;
        this.data = data;
        this.valorAbertura = valorAbertura;
        this.valorFechamento = valorFechamento;
        this.teste = teste;
    }

    public RespostaAcaoDTO(){

    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData() {
        return data;
    }

    public BigDecimal getValorAbertura() {
        return valorAbertura;
    }

    public BigDecimal getValorFechamento() {
        return valorFechamento;
    }

    public String getTeste() {
        return teste;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setValorAbertura(BigDecimal valorAbertura) {
        this.valorAbertura = valorAbertura;
    }

    public void setValorFechamento(BigDecimal valorFechamento) {
        this.valorFechamento = valorFechamento;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        RespostaAcaoDTO that = (RespostaAcaoDTO) object;
        return java.util.Objects.equals(nome, that.nome) && java.util.Objects.equals(data, that.data) && java.util.Objects.equals(valorAbertura, that.valorAbertura) && java.util.Objects.equals(valorFechamento, that.valorFechamento) && java.util.Objects.equals(teste, that.teste);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), nome, data, valorAbertura, valorFechamento, teste);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "RespostaAcaoDTO{" +
                "nome='" + nome + '\'' +
                ", data=" + data +
                ", valorAbertura=" + valorAbertura +
                ", valorFechamento=" + valorFechamento +
                ", teste='" + teste + '\'' +
                '}';
    }
}
