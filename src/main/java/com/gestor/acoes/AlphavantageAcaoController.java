package com.gestor.acoes;

import com.gestor.util.dto.BigDecimalDTO;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/acao")
public class AlphavantageAcaoController {

    @Inject
    private AlphavantageAcaoService service;

    @GET
    @Path("valorAcaoHoje/{codigoAcao}")
    public Response obterRespostaAcao(@PathParam String codigoAcao) {
        RespostaAcaoDTO respostaAcaoDTO = service.obterRespostaAcao(codigoAcao);
        return Response.ok(respostaAcaoDTO).build();
    }

    @POST
    @Path("criarMock")
    public Response criarMock() {
        service.createMockAcoes();
        return Response.ok().build();
    }

    @GET
    @Path("somatorioAcoes/{idUsuario}")
    public BigDecimalDTO somatorioAcoes(@PathParam Long idUsuario) {
        return service.somatorioAcoes(idUsuario);
    }

}
