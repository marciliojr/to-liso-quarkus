package com.gestor.acoes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Acao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal valorAbertura;
    private BigDecimal valorFechamento;
    private LocalDate  data;
    private String nome;

    public Acao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acao acoes = (Acao) o;
        return Objects.equals(data, acoes.data) && Objects.equals(nome, acoes.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, nome);
    }

    @Override
    public String toString() {
        return "Acoes{" +
                "id=" + id +
                ", valorAbertura=" + valorAbertura +
                ", valorFechamento=" + valorFechamento +
                ", data=" + data +
                ", nome='" + nome + '\'' +
                '}';
    }
}
