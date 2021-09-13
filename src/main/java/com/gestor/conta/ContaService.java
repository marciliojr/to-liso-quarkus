package com.gestor.conta;

import com.gestor.banco.Banco;
import com.gestor.despesa.Despesa;
import com.gestor.usuario.Usuario;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;

@RequestScoped
public class ContaService {

    @Transactional
    public void insere() {

        Usuario usuario = new Usuario();
        usuario.email = "marcilio@bbb.com";
        usuario.nick = "marcilio";
        usuario.senha = "123";

        Usuario.persist(usuario);

        Banco banco = new Banco();
        banco.agencia = "001";
        banco.nome = "Nubank";
        banco.numero = 260;

        Banco.persist(banco);

        Conta conta = new Conta();
        conta.banco = banco;
        conta.saldo = BigDecimal.ZERO;
        conta.usuario = usuario;

        Conta.persist(conta);

    }


    public Conta buscarPorBanco(Long id){
        return Conta.buscarPorBanco(id);
    }



}
