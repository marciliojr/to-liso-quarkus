package com.gestor.usuario;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Usuario extends PanacheEntity implements Serializable {
    @NotNull
    public String email;
    @NotNull
    public String nick;
    @NotNull
    public String senha;
}
