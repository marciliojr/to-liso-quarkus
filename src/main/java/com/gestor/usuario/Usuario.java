package com.gestor.usuario;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Usuario extends PanacheEntity implements Serializable {
    public String email;
    public String nick;
    public String senha;
}
