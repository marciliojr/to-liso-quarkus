package com.gestor.despesa;

import com.gestor.despesa.dto.DespesaDTO;
import com.gestor.despesa.dto.ListaResponseDespesaDTO;
import com.gestor.util.dto.BigDecimalDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ApplicationScoped
public class DespesaRepository implements PanacheRepository<Despesa> {

    private Date dataInicial;
    private Date dataFinal;
    private LocalDateTime mesInicial;
    private LocalDateTime mesFinal;

    public DespesaRepository() {
        LocalDateTime hoje = LocalDateTime.now();
        mesInicial = LocalDateTime.of(hoje.getYear(), hoje.getMonthValue(), 1, 0, 0);
        mesFinal = mesInicial.plusMonths(1l).minusDays(1l);
        dataInicial = Date.from(mesInicial.atZone(ZoneId.systemDefault()).toInstant());
        dataFinal = Date.from(mesFinal.atZone(ZoneId.systemDefault()).toInstant());

    }

    public BigDecimalDTO obterSaldoDespesasMes(Long idUsuario) {
        StringBuilder queryHN = new StringBuilder();

        queryHN.append("SELECT SUM(r.valor) FROM Despesa r INNER JOIN Conta c ON c.id = r.conta_id INNER JOIN Usuario u ON u.id = c.id WHERE u.id = :idUsuario AND r.dataHoraDespesa >= :mesInicial AND r.dataHoraDespesa <= :mesFinal");
        BigDecimal somatorio = (BigDecimal) getEntityManager().createNativeQuery(queryHN.toString()).setParameter("idUsuario", idUsuario).setParameter("mesInicial", dataInicial).setParameter("mesFinal", dataFinal).getSingleResult();
        BigDecimalDTO valor = new BigDecimalDTO(somatorio);
        return valor;
    }


    public ListaResponseDespesaDTO obterDespesasMes(Long idUsuario) {
        Map<String, Object> params = new HashMap<>();
        params.put("idUsuario", idUsuario);
        params.put("mesInicial", mesInicial);
        params.put("mesFinal", mesFinal);

        StringBuilder query = new StringBuilder();
        query.append("conta.usuario.id = :idUsuario AND dataHoraDespesa >= :mesInicial AND dataHoraDespesa <= :mesFinal");

        List<Despesa> resultado = list(query.toString(), params);

        List<DespesaDTO> dtos = resultado.stream().map(despesa -> {
            DespesaDTO dto = new DespesaDTO(despesa);
            return dto;
        }).collect(Collectors.toList());


        return new ListaResponseDespesaDTO(dtos);
    }


}