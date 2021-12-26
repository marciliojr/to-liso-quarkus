package com.gestor.conta;

import com.gestor.despesa.Despesa;
import com.gestor.util.dto.BigDecimalDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class ContaRepository implements PanacheRepository<Conta> {

    public Conta buscarPorBanco(Integer codigoBanco) {
        Map<String, Object> params = new HashMap<>();
        params.put("codigoBanco", codigoBanco);
        return find("banco.codigo = :codigoBanco ", params).firstResult();
    }

    public BigDecimalDTO obterSaldoGeralContas(String emailUsuario){
        StringBuilder queryHN = new StringBuilder();
        queryHN.append("SELECT SUM(c.saldo)  FROM Conta c  INNER JOIN Usuario u ON u.id  = c.usuario_id WHERE u.email = :usuarioEmail ");

        BigDecimal somatorio = (BigDecimal) getEntityManager().createNativeQuery(queryHN.toString()).setParameter("usuarioEmail",emailUsuario).getSingleResult();
        BigDecimalDTO valor = new BigDecimalDTO(somatorio);
        return valor;
    }
}