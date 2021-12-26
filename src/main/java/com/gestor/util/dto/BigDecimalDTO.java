package com.gestor.util.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class BigDecimalDTO implements Serializable {

    private BigDecimal valor;


    public BigDecimalDTO() {
    }

    public BigDecimalDTO(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BigDecimalDTO that = (BigDecimalDTO) o;
        return Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return "BigDecimalDTO{" +
                "valor=" + valor +
                '}';
    }
}
