package com.gestor.config;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Configuracoes implements Serializable {
    private static final long serialVersionUID = -1686440644693207231L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String chave;
    @NotEmpty
    private String valor;

    public Configuracoes() {
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuracoes that = (Configuracoes) o;
        return Objects.equals(chave, that.chave) && Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chave, valor);
    }

    @Override
    public String toString() {
        return "Configuracoes{" +
                "chave='" + chave + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
