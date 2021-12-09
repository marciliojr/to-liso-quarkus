package com.gestor.usuario.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class UsuarioRespostaDTO {

    private String nick;
    private String email;

    public UsuarioRespostaDTO(String nick, String email) {
        this.nick = nick;
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nome) {
        this.nick = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UsuarioRespostaDTO{" +
                "nick='" + nick + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
