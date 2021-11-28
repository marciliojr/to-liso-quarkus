package com.gestor.conta;

import com.gestor.despesa.Despesa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class ContaRepository implements PanacheRepository<Conta> {

    public Conta buscarPorBanco(Integer codigoBanco) {
        Map<String, Object> params = new HashMap<>();
        params.put("codigoBanco", codigoBanco);
        return find("banco.numero = :codigoBanco ", params).firstResult();
    }

    public BigDecimal getSaldoRealConta(Integer codigoBanco, String emailUsuario) {

        Map<String, Object> params = new HashMap<>();
        params.put("usuarioEmail", emailUsuario);
        params.put("codigoBanco", codigoBanco);

        Conta conta = find("banco.numero = :codigoBanco AND usuario.email = :usuarioEmail", params).firstResult();
        BigDecimal saldo = conta.getSaldo();

        BigDecimal valor = BigDecimal.ZERO;
        BigDecimal resposta = BigDecimal.ZERO;
        List<Despesa> despesas = conta.getDespesas();

        for (Despesa d : despesas) {
            resposta = valor.add(d.valor);
        }

        return saldo.subtract(resposta);
    }
}