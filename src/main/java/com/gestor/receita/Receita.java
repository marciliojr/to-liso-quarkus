package com.gestor.receita;

import com.gestor.conta.Conta;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Receita  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public BigDecimal valor;

    public LocalDateTime dataHoraReceita;

    public String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHoraReceita() {
        return dataHoraReceita;
    }

    public void setDataHoraReceita(LocalDateTime dataHoraReceita) {
        this.dataHoraReceita = dataHoraReceita;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receita receita = (Receita) o;
        return Objects.equals(valor, receita.valor) && Objects.equals(dataHoraReceita, receita.dataHoraReceita) && Objects.equals(descricao, receita.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, dataHoraReceita, descricao);
    }

    @Override
    public String toString() {
        return "Receita{" +
                "valor=" + valor +
                ", dataHoraReceita=" + dataHoraReceita +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
