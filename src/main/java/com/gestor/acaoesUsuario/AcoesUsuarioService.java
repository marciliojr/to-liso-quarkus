package com.gestor.acaoesUsuario;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class AcoesUsuarioService {

    @Inject
    private AcoesUsuarioRepository repository;

    public List<AcoesUsuario> obterAcoesUsuario(Long idUsuario) {
       return repository.obterAcoesUsuario(idUsuario);
    }



}
