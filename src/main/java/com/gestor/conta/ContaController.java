package com.gestor.conta;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/conta")
public class ContaController {

    @Inject
    private ContaService service;

    @POST
    public Response insere(){
        try {
            service.insere();
        }catch (Exception e){
            return Response.status(400,e.getMessage()).build();
        }
        return Response.status(201).build();
    }

    @GET
    @Path("banco/{id}")
    public Response name(@PathParam Long id) {
        Conta resposta = service.buscarPorBanco(id);
        return Response.ok(resposta).build();
    }


}
