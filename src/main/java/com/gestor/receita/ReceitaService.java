package com.gestor.receita;

import com.gestor.usuario.UsuarioRepository;
import com.gestor.util.dto.BigDecimalDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class ReceitaService {

    @Inject
    private ReceitaRepository repositorio;

    public BigDecimalDTO obterSaldoReceitasMes(Long idUsuario) {
        return repositorio.obterSaldoReceitasMes(idUsuario);
    }

}
