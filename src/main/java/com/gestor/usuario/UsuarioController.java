package com.gestor.usuario;

import com.gestor.exceptions.NegocioException;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.validation.Valid;
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
    @APIResponse(
	responseCode = "200",
	description = "Serviço responsavel pela criação do usuario.",
	content = @Content(mediaType = MediaType.APPLICATION_JSON)
)
    public Response insere(Usuario usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException, NegocioException {
        service.insere(usuario);
        return Response.ok().build();
    }

    @GET
    @APIResponse(
            responseCode = "200",
            description = "Serviço que retorna um usuario apartir do seu email.",
            content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @Path("buscarPorEmail/{email}")
    public Response buscarPorEmail(@PathParam String email) {
        return Response.ok(service.buscarPorEmail(email)).build();
    }


}
