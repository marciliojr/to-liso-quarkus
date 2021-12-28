package com.gestor.receita;

import com.gestor.conta.ContaService;
import com.gestor.util.dto.BigDecimalDTO;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/receita")
public class ReceitaController {

    @Inject
    private ReceitaService service;

    @GET
    @Path("saldoReceitaMes/{idUsuario}")
    public Response obterSaldoGeralContas(@PathParam Long idUsuario) {
        BigDecimalDTO resposta = service.obterSaldoReceitasMes(idUsuario);
        return Response.ok(resposta).build();
    }

}
