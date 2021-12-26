package com.gestor.receita;

import com.gestor.util.dto.BigDecimalDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@ApplicationScoped
public class ReceitaRepository implements PanacheRepository<Receita> {


    public BigDecimalDTO obterSaldoReceitasMes(String emailUsuario) {
        StringBuilder queryHN = new StringBuilder();
        queryHN.append("SELECT SUM(r.valor) FROM Receita r INNER JOIN Conta c ON c.id = r.conta_id INNER JOIN Usuario u ON u.id = c.id WHERE u.email = :usuarioEmail ");
        BigDecimal somatorio = (BigDecimal) getEntityManager().createNativeQuery(queryHN.toString()).setParameter("usuarioEmail", emailUsuario).getSingleResult();
        BigDecimalDTO valor = new BigDecimalDTO(somatorio);
        return valor;
    }


}
