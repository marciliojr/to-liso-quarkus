package com.gestor.conta;

import com.gestor.util.dto.BigDecimalDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class ContaRepository implements PanacheRepository<Conta> {

    public Conta buscarPorBanco(Integer codigoBanco) {
        Map<String, Object> params = new HashMap<>();
        params.put("codigoBanco", codigoBanco);
        return find("banco.codigo = :codigoBanco ", params).firstResult();
    }

    public BigDecimalDTO obterSaldoGeralContas(Long idUsuario){
        StringBuilder queryHN = new StringBuilder();
        queryHN.append("SELECT SUM(c.saldo)  FROM Conta c  INNER JOIN Usuario u ON u.id  = c.usuario_id WHERE u.id = :idUsuario ");
        BigDecimal somatorio = (BigDecimal) getEntityManager().createNativeQuery(queryHN.toString()).setParameter("idUsuario",idUsuario).getSingleResult();
        BigDecimalDTO valor = new BigDecimalDTO(somatorio);
        return valor;
    }
}