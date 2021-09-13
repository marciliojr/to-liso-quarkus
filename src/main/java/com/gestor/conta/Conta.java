package com.gestor.conta;

import com.gestor.banco.Banco;
import com.gestor.despesa.Despesa;
import com.gestor.receita.Receita;
import com.gestor.usuario.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Conta extends PanacheEntity implements Serializable {
    @OneToOne
    public Banco banco;
    @OneToOne
    public Usuario usuario;
    public BigDecimal saldo;
    @OneToMany(fetch = FetchType.LAZY)
    public List<Despesa> despesa;
    @OneToMany(fetch = FetchType.LAZY)
    public List<Receita> receita;


    public static Conta buscarPorBanco(Long idBanco){
        Map<String, Object> params = new HashMap<>();
        params.put("idBanco", idBanco);
        return Conta.find("banco.id = :idBanco ", params).firstResult();
    }

    @Override
    public String toString() {
        return "Conta{" +
                "banco=" + banco +
                ", usuario=" + usuario +
                ", saldo=" + saldo +
                '}';
    }
}
