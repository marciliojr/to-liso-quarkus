package com.gestor.config;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Map;

@RequestScoped
public class ConfiguracoesService {

    @Inject
    private ConfiguracoesRepository repository;

    public Map<String,String> getMapaConfiguracao(){
        return repository.getMapaConfiguracao();
    }


}

