package com.gestor.acaoesUsuario;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AcoesUsuarioRepository implements PanacheRepository<AcoesUsuario> {


    public List<AcoesUsuario> obterAcoesUsuario(Long idUsuario) {
        Map<String, Object> param = new HashMap<>();
        param.put("idUsuario", idUsuario);
        String sql = "usuario.id = :idUsuario";
        List<AcoesUsuario> lista = find(sql, param).list();
        return lista;
    }

}
