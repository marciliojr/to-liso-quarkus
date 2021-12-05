package com.gestor.usuario;

import com.gestor.exceptions.NegocioException;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {


    public boolean existeUsuarioComEmail(String email){
      return  find("email", email).count() > 0;
    }

}
