package com.gestor.receita;

import com.gestor.cartao.Cartao;
import com.gestor.categoria.Categoria;
import com.gestor.conta.Conta;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Receita  implements Serializable {

    private static final long serialVersionUID = 4979359375398234088L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    private LocalDateTime dataHoraReceita;

    @NotEmpty
    private String descricao;

    @OneToOne
    private Conta conta;

    @OneToOne
    private Cartao cartao;

    @OneToOne
    private Categoria categoria;


}
