package com.gestor.config;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class ConfiguracoesRepository implements PanacheRepository<Configuracoes> {


    public Map<String,String> getMapaConfiguracao(){
        Map<String, String> mapa;

        List<Configuracoes> list = findAll().list();

        mapa  = list.stream().collect(
                Collectors.toMap(Configuracoes::getChave, Configuracoes::getValor));

        return mapa;
    }

}
