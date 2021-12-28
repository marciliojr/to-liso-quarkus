package com.gestor.despesa.dto;

import com.gestor.despesa.Despesa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class DespesaDTO implements Serializable {
    private static final long serialVersionUID = 6169158545693989158L;

    private Long id;
    public BigDecimal valor;
    public String descricao;
    public LocalDateTime dataHoraDespesa;

    public DespesaDTO(Despesa despesa) {
        setId(despesa.getId());
        setDataHoraDespesa(despesa.getDataHoraDespesa());
        setDescricao(despesa.getDescricao());
        setValor(despesa.getValor());
    }

    public DespesaDTO() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DespesaDTO that = (DespesaDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(valor, that.valor) && Objects.equals(descricao, that.descricao) && Objects.equals(dataHoraDespesa, that.dataHoraDespesa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, descricao, dataHoraDespesa);
    }

    @Override
    public String toString() {
        return "DespesaDTO{" +
                "id=" + id +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", dataHoraDespesa=" + dataHoraDespesa +
                '}';
    }
}
