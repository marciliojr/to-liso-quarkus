package com.gestor.cartao;

import java.util.Arrays;
import java.util.Optional;

public enum TipoCartao {

    DEBITO(1, "Debito"),
    CREDITO(2,"Credito"),
    VOUCHER(3, "Voucher");

    private Integer codigo;
    private String descricao;

    TipoCartao(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoCartao obterEnumPorCodigo(Integer codigo) {
        Optional<TipoCartao> tipoCartao = Arrays.stream(TipoCartao.values()).filter(resposta -> resposta.codigo.equals(codigo)).findFirst();
        return tipoCartao.orElse(null);
    }


}
