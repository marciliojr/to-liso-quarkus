package com.gestor.despesa;

import com.gestor.cartao.TipoCartao;

import java.util.Arrays;
import java.util.Optional;

public enum TipoDespesa {

    CONTA(1,"Conta"),
    CARTAO(2,"Cartão");

    private Integer codigo;
    private String descricao;

    TipoDespesa(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoDespesa obterEnumPorCodigo(Integer codigo) {
        Optional<TipoDespesa> tipoDespesa = Arrays.stream(TipoDespesa.values()).filter(resposta -> resposta.codigo.equals(codigo)).findFirst();
        return tipoDespesa.orElse(null);
    }

}
