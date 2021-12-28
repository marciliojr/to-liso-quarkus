package com.gestor.conta.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ListaResponseContaDTO implements Serializable {
    private static final long serialVersionUID = -5449179224048119704L;

    private List<ContaDTO> contas;

    public ListaResponseContaDTO() {
    }

    public List<ContaDTO> getContas() {
        return contas;
    }

    public void setContas(List<ContaDTO> contas) {
        this.contas = contas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaResponseContaDTO that = (ListaResponseContaDTO) o;
        return Objects.equals(contas, that.contas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contas);
    }

    @Override
    public String toString() {
        return "ListaResponseContaDTO{" +
                "contas=" + contas +
                '}';
    }
}
