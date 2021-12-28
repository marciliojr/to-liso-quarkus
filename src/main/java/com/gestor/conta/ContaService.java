package com.gestor.conta;

import com.gestor.banco.Banco;
import com.gestor.despesa.Despesa;
import com.gestor.usuario.Usuario;
import com.gestor.util.dto.BigDecimalDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;

@RequestScoped
public class ContaService {

    @Inject
    private ContaRepository repositorio;

    @Transactional
    public void insere(Conta conta) {
    repositorio.persist(conta);

    }

    public Conta buscarPorBanco(Integer codigoBanco) {
        return repositorio.buscarPorBanco(codigoBanco);
    }

   public BigDecimalDTO obterSaldoGeralContas(Long idUsuario){
        return repositorio.obterSaldoGeralContas(idUsuario);
   }


}
