package com.gestor.acoes;

import com.gestor.receita.Receita;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AcaoRepository implements PanacheRepository<Acao> {


    public void salvarMock(RespostaAcaoDTO acaoDTO){
        Acao acao = new Acao();
        acao.setData(acaoDTO.getData());
        acao.setNome(acaoDTO.getNome());
        acao.setValorAbertura(acaoDTO.getValorAbertura());
        acao.setValorFechamento(acaoDTO.getValorFechamento());
        persist(acao);
    }

}
