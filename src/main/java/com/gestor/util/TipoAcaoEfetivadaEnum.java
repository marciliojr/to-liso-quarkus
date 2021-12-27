package com.gestor.util;

import com.gestor.cartao.TipoCartao;

import java.util.Arrays;
import java.util.Optional;

public enum TipoAcaoEfetivadaEnum {

    EFETIVADA(1, "Debito"),
    AGUARDANDO(2,"Credito");

    private Integer codigo;
    private String descricao;

    TipoAcaoEfetivadaEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoAcaoEfetivadaEnum obterEnumPorCodigo(Integer codigo) {
        Optional<TipoAcaoEfetivadaEnum> tipoAcao = Arrays.stream(TipoAcaoEfetivadaEnum.values()).filter(resposta -> resposta.codigo.equals(codigo)).findFirst();
        return tipoAcao.orElse(null);
    }


}
