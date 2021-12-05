package com.gestor.exceptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NegocioExceptionDTO implements Serializable {

    private List<String> mensagens = new ArrayList<String>();

    public NegocioExceptionDTO() {
    }

    public NegocioExceptionDTO(String mensagem) {
        mensagens.add(mensagem);
    }

    public NegocioExceptionDTO(List<String> mensagens) {
        this.mensagens = mensagens;
    }

    public void addMensagem(String mensagem){
        mensagens.add(mensagem);
    }

    public List<String> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<String> mensagens) {
        this.mensagens = mensagens;
    }

    public boolean comMensagens(){
       return !this.mensagens.isEmpty();
    }

    @Override
    public String toString() {
        return "{" +
                "mensagens=" + mensagens +
                '}';
    }
}
