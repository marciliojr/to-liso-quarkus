package com.gestor.conta;

import com.gestor.conta.dto.ListaResponseContaDTO;
import com.gestor.util.dto.BigDecimalDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

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


    public ListaResponseContaDTO obterContasUsuario(Long idUsuario) {
        return repositorio.obterContasUsuario(idUsuario);
    }
}
