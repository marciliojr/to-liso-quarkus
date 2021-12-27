package com.gestor.despesa;

import com.gestor.util.dto.BigDecimalDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@ApplicationScoped
public class DespesaRepository implements PanacheRepository<Despesa> {


    public BigDecimalDTO obterSaldoDespesasMes(String emailUsuario) {
        StringBuilder queryHN = new StringBuilder();
        LocalDateTime hoje = LocalDateTime.now();
        LocalDateTime mesInicial = LocalDateTime.of(hoje.getYear(),hoje.getMonthValue(),1,0,0);
        LocalDateTime mesFinal = mesInicial.plusMonths(1l).minusDays(1l);

        Date dataInicial = Date.from(mesInicial.atZone(ZoneId.systemDefault()).toInstant());
        Date dataFinal = Date.from(mesFinal.atZone(ZoneId.systemDefault()).toInstant());

        queryHN.append("SELECT SUM(r.valor) FROM Despesa r INNER JOIN Conta c ON c.id = r.conta_id INNER JOIN Usuario u ON u.id = c.id WHERE u.email = :usuarioEmail AND r.dataHoraDespesa >= :mesInicial AND r.dataHoraDespesa <= :mesFinal");
        BigDecimal somatorio = (BigDecimal) getEntityManager().createNativeQuery(queryHN.toString()).setParameter("usuarioEmail", emailUsuario).setParameter("mesInicial", dataInicial).setParameter("mesFinal", dataFinal).getSingleResult();
        BigDecimalDTO valor = new BigDecimalDTO(somatorio);
        return valor;
    }
}