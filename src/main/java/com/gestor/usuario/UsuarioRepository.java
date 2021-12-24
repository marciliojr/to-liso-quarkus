package com.gestor.usuario;

import com.gestor.exceptions.NegocioException;
import com.gestor.usuario.dto.UsuarioAutenticadoDTO;
import com.gestor.usuario.dto.UsuarioRespostaDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {


    public boolean existeUsuarioComEmail(String email){
      return  find("email", email).count() > 0;
    }

    public UsuarioRespostaDTO login(UsuarioAutenticadoDTO email){

        Map<String, Object> params = new HashMap<>();
        params.put("email", email.getEmail());
        params.put("senha", email.getSenha());
       return find("email = :email and senha = :senha", params).project(UsuarioRespostaDTO.class).firstResult();
    }

}
