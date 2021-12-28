package com.gestor.receita;

import com.gestor.util.dto.BigDecimalDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@ApplicationScoped
public class ReceitaRepository implements PanacheRepository<Receita> {


    public BigDecimalDTO obterSaldoReceitasMes(Long idUsuario) {
        StringBuilder queryHN = new StringBuilder();
        LocalDateTime hoje = LocalDateTime.now();
        LocalDateTime mesInicial = LocalDateTime.of(hoje.getYear(),hoje.getMonthValue(),1,0,0);
        LocalDateTime mesFinal = mesInicial.plusMonths(1l).minusDays(1l);

        Date dataInicial = Date.from(mesInicial.atZone(ZoneId.systemDefault()).toInstant());
        Date dataFinal = Date.from(mesFinal.atZone(ZoneId.systemDefault()).toInstant());

        queryHN.append("SELECT SUM(r.valor) FROM Receita r INNER JOIN Conta c ON c.id = r.conta_id INNER JOIN Usuario u ON u.id = c.id WHERE u.id = :idUsuario AND r.dataHoraReceita >= :mesInicial AND r.dataHoraReceita <= :mesFinal");
        BigDecimal somatorio = (BigDecimal) getEntityManager().createNativeQuery(queryHN.toString()).setParameter("usuarioEmail", idUsuario).setParameter("mesInicial", dataInicial).setParameter("mesFinal", dataFinal).getSingleResult();
        BigDecimalDTO valor = new BigDecimalDTO(somatorio);
        return valor;
    }


}
