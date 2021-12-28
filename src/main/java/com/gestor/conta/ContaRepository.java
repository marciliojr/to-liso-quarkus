package com.gestor.conta;

import com.gestor.conta.dto.ContaDTO;
import com.gestor.conta.dto.ListaResponseContaDTO;
import com.gestor.util.dto.BigDecimalDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.util.ArrayList;
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

    public BigDecimalDTO obterSaldoGeralContas(Long idUsuario){
        StringBuilder queryHN = new StringBuilder();
        queryHN.append("SELECT SUM(c.saldo)  FROM Conta c  INNER JOIN Usuario u ON u.id  = c.usuario_id WHERE u.id = :idUsuario ");
        BigDecimal somatorio = (BigDecimal) getEntityManager().createNativeQuery(queryHN.toString()).setParameter("idUsuario",idUsuario).getSingleResult();
        BigDecimalDTO valor = new BigDecimalDTO(somatorio);
        return valor;
    }

    public ListaResponseContaDTO obterContasUsuario(Long idUsuario) {

        Map<String, Object> params = new HashMap<>();
        params.put("idUsuario", idUsuario);

        List<Conta> lista = list("usuario.id = :idUsuario", params);

        List<ContaDTO> listaDTO  = lista.stream().map(conta -> {
            ContaDTO dto = new ContaDTO(conta);
            return  dto;
        }).collect(Collectors.toList());

        ListaResponseContaDTO response = new ListaResponseContaDTO();
        response.setContas(listaDTO);

        return response;
    }
}