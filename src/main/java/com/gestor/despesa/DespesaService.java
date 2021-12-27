package com.gestor.despesa;

import com.gestor.receita.ReceitaRepository;
import com.gestor.util.dto.BigDecimalDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class DespesaService {

    @Inject
    private DespesaRepository repositorio;

    public BigDecimalDTO obterSaldoDespesasMes(String emailUsuario) {
        return repositorio.obterSaldoDespesasMes(emailUsuario);
    }


}
