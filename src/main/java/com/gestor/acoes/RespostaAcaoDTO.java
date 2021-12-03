package com.gestor.acoes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class RespostaAcaoDTO implements Serializable {

    private String nome;
    private LocalDate data;
    private BigDecimal valorAbertura;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespostaAcaoDTO that = (RespostaAcaoDTO) o;
        return nome.equals(that.nome) && data.equals(that.data) && valorAbertura.equals(that.valorAbertura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, data, valorAbertura);
    }
    @Override
    public String toString() {
        return "RespostaAcaoDTO{" +
                "nome='" + nome + '\'' +
                ", data=" + data +
                ", valorAbertura=" + valorAbertura +
                '}';
    }
}
