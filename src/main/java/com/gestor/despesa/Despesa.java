package com.gestor.despesa;

import com.gestor.conta.Conta;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Despesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    public BigDecimal valor;

    @NotEmpty
    @Size(max = 100)
    public String descricao;

    @NotNull
    public LocalDateTime dataHoraDespesa;

    public Despesa() {
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHoraDespesa() {
        return dataHoraDespesa;
    }

    public void setDataHoraDespesa(LocalDateTime dataHoraDespesa) {
        this.dataHoraDespesa = dataHoraDespesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Despesa despesa = (Despesa) o;
        return valor.equals(despesa.valor) && descricao.equals(despesa.descricao) && dataHoraDespesa.equals(despesa.dataHoraDespesa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, descricao, dataHoraDespesa);
    }

    @Override
    public String toString() {
        return "Despesa{" +
                "valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", dataHoraDespesa=" + dataHoraDespesa +
                '}';
    }
}
