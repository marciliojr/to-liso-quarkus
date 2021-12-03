package com.gestor.acoes;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/acao")
public class AlphavantageAcaoController {

    @Inject
    private AlphavantageAcaoService service;

    @GET
    @Path("valorAcaoHoje/{codigoAcao}")
    public Response obterRespostaAcao(@PathParam String codigoAcao){
        RespostaAcaoDTO respostaAcaoDTO = service.obterRespostaAcao(codigoAcao);
        return Response.ok(respostaAcaoDTO).build();
    }

    @GET
    @Path("valorAcaoHojeTeste")
    public Response obterRespostaAcao(){
        RespostaAcaoDTO respostaAcaoDTO = service.obterRespostaAcao("RECR11");
        return Response.ok(respostaAcaoDTO).build();
    }


}
