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
    @Path("saldoReceitaMes/{usuarioEmail}")
    public Response obterSaldoGeralContas(@PathParam String usuarioEmail) {
        BigDecimalDTO resposta = service.obterSaldoReceitasMes(usuarioEmail);
        return Response.ok(resposta).build();
    }

}
