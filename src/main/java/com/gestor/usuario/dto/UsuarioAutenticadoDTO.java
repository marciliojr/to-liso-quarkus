package com.gestor.usuario.dto;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioAutenticadoDTO implements Serializable {

    private String email;
    private String senha;

    public UsuarioAutenticadoDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioAutenticadoDTO that = (UsuarioAutenticadoDTO) o;
        return Objects.equals(email, that.email) && Objects.equals(senha, that.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, senha);
    }
}
