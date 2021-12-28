package com.gestor.despesa.dto;

import java.util.List;
import java.util.Objects;

public class ListaResponseDespesaDTO {

    private List<DespesaDTO> despesas;

    public ListaResponseDespesaDTO(List<DespesaDTO> despesas) {
        this.despesas = despesas;
    }

    public ListaResponseDespesaDTO() {
    }

    public List<DespesaDTO> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<DespesaDTO> despesas) {
        this.despesas = despesas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaResponseDespesaDTO that = (ListaResponseDespesaDTO) o;
        return Objects.equals(despesas, that.despesas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(despesas);
    }

    @Override
    public String toString() {
        return "ListaResponseDespesaDTO{" +
                "despesas=" + despesas +
                '}';
    }
}
