package com.gestor.receita;

import com.gestor.cartao.Cartao;
import com.gestor.categoria.Categoria;
import com.gestor.conta.Conta;
import com.gestor.util.TipoAcaoEfetivadaEnum;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Receita  implements Serializable {

    private static final long serialVersionUID = 4979359375398234088L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    private LocalDateTime dataHoraReceita;

    @NotEmpty
    private String descricao;

    @OneToOne
    private Conta conta;

    @OneToOne
    private Cartao cartao;

    @OneToOne
    private Categoria categoria;

    @Enumerated
    private TipoAcaoEfetivadaEnum tipoAcao;

    public Receita() {
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
        Receita receita = (Receita) o;
        return Objects.equals(id, receita.id) && Objects.equals(valor, receita.valor) && Objects.equals(dataHoraReceita, receita.dataHoraReceita) && Objects.equals(descricao, receita.descricao) && Objects.equals(conta, receita.conta) && Objects.equals(cartao, receita.cartao) && Objects.equals(categoria, receita.categoria) && tipoAcao == receita.tipoAcao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, dataHoraReceita, descricao, conta, cartao, categoria, tipoAcao);
    }

    @Override
    public String toString() {
        return "Receita{" +
                "id=" + id +
                ", valor=" + valor +
                ", dataHoraReceita=" + dataHoraReceita +
                ", descricao='" + descricao + '\'' +
                ", conta=" + conta +
                ", cartao=" + cartao +
                ", categoria=" + categoria +
                ", tipoAcao=" + tipoAcao +
                '}';
    }
}
