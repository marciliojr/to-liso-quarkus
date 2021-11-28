package com.gestor.banco;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Banco extends PanacheEntity implements Serializable {

    public String nome;
    public String agencia;
    public Integer numero;


}
