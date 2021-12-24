package com.gestor.usuario;

import com.gestor.exceptions.NegocioException;
import com.gestor.usuario.dto.UsuarioAutenticadoDTO;
import com.gestor.usuario.dto.UsuarioDTO;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
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
    @Operation( description = "Serviço responsavel por cadastrar o usuario.")
    public Response insere(UsuarioDTO usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException, NegocioException {
        service.insere(usuario);
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Operation( description = "Serviço responsavel por Logar usuario.")
    @Path("login")
    public Response login(UsuarioAutenticadoDTO usuario) throws UnsupportedEncodingException, NoSuchAlgorithmException, NegocioException {
        return Response.ok(service.login(usuario)).build();
    }


}
