package com.gestor.conta;

import com.gestor.banco.Banco;
import com.gestor.despesa.Despesa;
import com.gestor.receita.Receita;
import com.gestor.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Conta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @NotNull
    private Banco banco;

    @NotNull
    @OneToOne
    private Usuario usuario;

    @Enumerated(EnumType.ORDINAL)
    private TipoConta tipoConta;

    private BigDecimal saldo;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Despesa> despesas;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Receita> receitas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "banco=" + banco +
                ", usuario=" + usuario +
                ", saldo=" + saldo +
                ", despesas=" + despesas +
                ", receitas=" + receitas +
                '}';
    }
}
