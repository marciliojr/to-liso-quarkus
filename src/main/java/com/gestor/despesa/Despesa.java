package com.gestor.despesa;

import com.gestor.conta.Conta;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Despesa extends PanacheEntity implements Serializable {

    public BigDecimal valor;
    public String origem;
    public LocalDateTime dataHoraDespesa;
    @ManyToOne
    public Conta conta;
}
