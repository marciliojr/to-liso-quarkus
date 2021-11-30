package com.gestor.conta;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;

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
    @Path("banco/{codigoBanco}")
    public Response name(@PathParam Integer codigoBanco) {
        Conta resposta = service.buscarPorBanco(codigoBanco);
        return Response.ok(resposta).build();
    }

    @GET
    @Path("saldoReal/{codigoBanco}/{usuarioEmail}")
    @APIResponse(name = "obter saldo real das contas (saldo atual - debitos")
    public Response name(@PathParam Integer codigoBanco, @PathParam String usuarioEmail) {
        BigDecimal resposta = service.getSaldoRealConta(codigoBanco, usuarioEmail);
        return Response.ok(resposta).build();
    }

}
