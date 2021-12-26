package com.gestor.cartao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Embossadora implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bandeira;
    @Enumerated
    private TipoCartao tipoCartao;

    public Embossadora() {
    }

    public Embossadora(Long id, String bandeira, TipoCartao tipoCartao) {
        this.id = id;
        this.bandeira = bandeira;
        this.tipoCartao = tipoCartao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public TipoCartao getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(TipoCartao tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Embossadora that = (Embossadora) o;
        return Objects.equals(id, that.id) && Objects.equals(bandeira, that.bandeira) && tipoCartao == that.tipoCartao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bandeira, tipoCartao);
    }

    @Override
    public String toString() {
        return "Embossadora{" +
                "id=" + id +
                ", bandeira='" + bandeira + '\'' +
                ", tipoCartao=" + tipoCartao +
                '}';
    }
}
