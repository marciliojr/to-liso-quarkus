package com.gestor.usuario;

import com.gestor.exceptions.NegocioException;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Path("/usuario")
public class UsuarioController {

    @Inject
    private UsuarioService service;

    @POST
    public Response insere(@Valid Usuario usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException, NegocioException {
        service.insere(usuario);
        return Response.ok().build();
    }





}
