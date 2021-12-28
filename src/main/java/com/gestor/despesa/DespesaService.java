package com.gestor.despesa;

import com.gestor.despesa.dto.DespesaDTO;
import com.gestor.despesa.dto.ListaResponseDespesaDTO;
import com.gestor.receita.ReceitaRepository;
import com.gestor.util.dto.BigDecimalDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class DespesaService {

    @Inject
    private DespesaRepository repositorio;

    public BigDecimalDTO obterSaldoDespesasMes(String emailUsuario) {
        return repositorio.obterSaldoDespesasMes(emailUsuario);
    }

    public ListaResponseDespesaDTO obterDespesasMes(String emailUsuario) {
        return repositorio.obterDespesasMes(emailUsuario);
    }


}
