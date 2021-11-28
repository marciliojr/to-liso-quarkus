package com.gestor.receita;

import com.gestor.conta.Conta;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Receita  implements Serializable {

    public BigDecimal valor;
    public LocalDateTime dataHoraReceita;
    public String descricao;

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
    public String toString() {
        return "Receita{" +
                "valor=" + valor +
                ", dataHoraReceita=" + dataHoraReceita +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
