package com.gestor.usuario.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

public class UsuarioDTO implements Serializable {


    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nick;
    @NotBlank
    private String senha;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String email, String nick, String senha) {
        this.email = email;
        this.nick = nick;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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
        UsuarioDTO that = (UsuarioDTO) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "email='" + email + '\'' +
                ", nick='" + nick + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
