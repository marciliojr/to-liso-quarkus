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

    public BigDecimalDTO obterSaldoDespesasMes(Long idUsuario) {
        return repositorio.obterSaldoDespesasMes(idUsuario);
    }

    public ListaResponseDespesaDTO obterDespesasMes(Long idUsuario) {
        return repositorio.obterDespesasMes(idUsuario);
    }


}
