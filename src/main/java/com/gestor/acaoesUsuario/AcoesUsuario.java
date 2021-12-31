package com.gestor.acaoesUsuario;

import com.gestor.acoes.Acao;
import com.gestor.usuario.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
@Entity
public class AcoesUsuario implements Serializable {
    private static final long serialVersionUID = -7439919918125183907L;
    @Id
    @ManyToOne
    private Usuario usuario;
    @Id
    @OneToOne
    private Acao acao;

    private BigDecimal quantidade;

    public AcoesUsuario() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcoesUsuario that = (AcoesUsuario) o;
        return Objects.equals(usuario, that.usuario) && Objects.equals(acao, that.acao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, acao);
    }

    @Override
    public String toString() {
        return "AcoesUsuario{" +
                "usuario=" + usuario +
                ", acao=" + acao +
                ", quantidade=" + quantidade +
                '}';
    }
}
