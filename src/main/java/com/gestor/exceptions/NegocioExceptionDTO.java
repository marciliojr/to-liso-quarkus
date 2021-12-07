package com.gestor.exceptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NegocioExceptionDTO implements Serializable {

    private List<String> mensagensDeErro = new ArrayList<String>();

    public NegocioExceptionDTO() {
    }

    public NegocioExceptionDTO(String mensagem) {
        mensagensDeErro.add(mensagem);
    }

    public NegocioExceptionDTO(List<String> mensagens) {
        this.mensagensDeErro = mensagens;
    }

    public void addMensagem(String mensagem){
        mensagensDeErro.add(mensagem);
    }

    public List<String> getMensagensDeErro() {
        return mensagensDeErro;
    }

    public void setMensagensDeErro(List<String> mensagensDeErro) {
        this.mensagensDeErro = mensagensDeErro;
    }

    public boolean comMensagens(){
       return !this.mensagensDeErro.isEmpty();
    }

    @Override
    public String toString() {
        return "{" +
                mensagensDeErro +
                '}';
    }
}
