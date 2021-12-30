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

    public RespostaAcaoDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getValorAbertura() {
        return valorAbertura;
    }

    public void setValorAbertura(BigDecimal valorAbertura) {
        this.valorAbertura = valorAbertura;
    }

    public BigDecimal getValorFechamento() {
        return valorFechamento;
    }

    public void setValorFechamento(BigDecimal valorFechamento) {
        this.valorFechamento = valorFechamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespostaAcaoDTO that = (RespostaAcaoDTO) o;
        return Objects.equals(nome, that.nome) && Objects.equals(data, that.data) && Objects.equals(valorAbertura, that.valorAbertura) && Objects.equals(valorFechamento, that.valorFechamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, data, valorAbertura, valorFechamento);
    }

    @Override
    public String toString() {
        return "RespostaAcaoDTO{" +
                "nome='" + nome + '\'' +
                ", data=" + data +
                ", valorAbertura=" + valorAbertura +
                ", valorFechamento=" + valorFechamento +
                '}';
    }
}
