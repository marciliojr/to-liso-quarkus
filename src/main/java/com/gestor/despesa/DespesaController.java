package com.gestor.despesa;

import com.gestor.receita.ReceitaService;
import com.gestor.util.dto.BigDecimalDTO;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/despesa")
public class DespesaController {

    @Inject
    private DespesaService service;

    @GET
    @Path("saldoDespesaMes/{usuarioEmail}")
    public Response obterSaldoGeralContas(@PathParam String usuarioEmail) {
        BigDecimalDTO resposta = service.obterSaldoDespesasMes(usuarioEmail);
        return Response.ok(resposta).build();
    }

}
