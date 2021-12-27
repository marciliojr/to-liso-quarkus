package com.gestor.despesa;

import com.gestor.cartao.Cartao;
import com.gestor.categoria.Categoria;
import com.gestor.conta.Conta;
import com.gestor.util.TipoAcaoEfetivadaEnum;
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

    private static final long serialVersionUID = -8711759674556844139L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    public BigDecimal valor;

    @NotEmpty
    @Size(max = 100)
    public String descricao;

    @NotNull
    public LocalDateTime dataHoraDespesa;

    @OneToOne
    private Conta conta;

    @OneToOne
    private Cartao cartao;

    @OneToOne
    private Categoria categoria;

    @Enumerated
    private TipoAcaoEfetivadaEnum tipoAcao;

    public Despesa() {
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

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public TipoAcaoEfetivadaEnum getTipoAcao() {
        return tipoAcao;
    }

    public void setTipoAcao(TipoAcaoEfetivadaEnum tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Despesa despesa = (Despesa) o;
        return Objects.equals(id, despesa.id) && Objects.equals(valor, despesa.valor) && Objects.equals(descricao, despesa.descricao) && Objects.equals(dataHoraDespesa, despesa.dataHoraDespesa) && Objects.equals(conta, despesa.conta) && Objects.equals(cartao, despesa.cartao) && Objects.equals(categoria, despesa.categoria) && tipoAcao == despesa.tipoAcao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, descricao, dataHoraDespesa, conta, cartao, categoria, tipoAcao);
    }

    @Override
    public String toString() {
        return "Despesa{" +
                "id=" + id +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", dataHoraDespesa=" + dataHoraDespesa +
                ", conta=" + conta +
                ", cartao=" + cartao +
                ", categoria=" + categoria +
                ", tipoAcao=" + tipoAcao +
                '}';
    }
}
