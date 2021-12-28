package com.gestor.cartao;

import com.gestor.despesa.Despesa;
import com.gestor.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Cartao implements Serializable {

    private static final long serialVersionUID = -5473715249841432856L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nome;
    @OneToOne
    private Embossadora embossadora;

    @NotNull
    @OneToOne
    private Usuario usuario;

    public Cartao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Embossadora getEmbossadora() {
        return embossadora;
    }

    public void setEmbossadora(Embossadora embossadora) {
        this.embossadora = embossadora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cartao cartao = (Cartao) o;
        return Objects.equals(id, cartao.id) && Objects.equals(nome, cartao.nome) && Objects.equals(embossadora, cartao.embossadora) && Objects.equals(usuario, cartao.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, embossadora, usuario);
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", embossadora=" + embossadora +
                ", usuario=" + usuario +
                '}';
    }
}
