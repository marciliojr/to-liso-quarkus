package com.gestor.conta;

import java.util.Arrays;

public enum TipoConta {

    CONTA_CORRENTE(1, "Corrente"),
    CONTA_SALARIO(2,"Salario"),
    CONTA_POUPANÇA(3, "Poupança"),
    CONTA_DIGITAL(4,"Digital");

    private Integer codigo;
    private String descricao;

    TipoConta(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoConta obterEnumPorCodigo(Integer codigo) {

        Arrays.stream(TipoConta.values()).filter(resposta -> resposta.codigo.equals(codigo)).findFirst();

        return null;
    }
}
