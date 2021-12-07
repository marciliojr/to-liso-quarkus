package com.gestor.usuario;

import com.gestor.exceptions.NegocioException;
import com.gestor.usuario.dto.UsuarioDTO;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
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

    @GET
    @Operation( description = "Serviço responsavel por retornar Usuario por email.")
    @Path("buscarPorEmail/{email}")
    public Response buscarPorEmail(@PathParam String email) {
        return Response.ok(service.buscarPorEmail(email)).build();
    }


}
