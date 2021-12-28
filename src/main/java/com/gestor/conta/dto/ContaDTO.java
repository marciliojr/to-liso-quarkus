package com.gestor.conta.dto;

import com.gestor.conta.Conta;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class ContaDTO implements Serializable {
    private static final long serialVersionUID = -5078903715618045817L;

    private Long id;
    private Long idBanco;
    private String nomeBanco;
    private Long codigoUsuario;
    private Integer codigoTipoConta;
    private BigDecimal saldo;

    public ContaDTO(Conta conta) {
        this.id = conta.getId();
        this.saldo = conta.getSaldo();
        this.idBanco = conta.getBanco().getId();
        this.nomeBanco = conta.getBanco().getNome();
        this.codigoUsuario = conta.getUsuario().getId();
        this.codigoTipoConta = conta.getTipoConta().getCodigo();

    }

    public ContaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Long idBanco) {
        this.idBanco = idBanco;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public Long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Integer getCodigoTipoConta() {
        return codigoTipoConta;
    }

    public void setCodigoTipoConta(Integer codigoTipoConta) {
        this.codigoTipoConta = codigoTipoConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaDTO contaDTO = (ContaDTO) o;
        return Objects.equals(id, contaDTO.id) && Objects.equals(idBanco, contaDTO.idBanco) && Objects.equals(nomeBanco, contaDTO.nomeBanco) && Objects.equals(codigoUsuario, contaDTO.codigoUsuario) && Objects.equals(codigoTipoConta, contaDTO.codigoTipoConta) && Objects.equals(saldo, contaDTO.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idBanco, nomeBanco, codigoUsuario, codigoTipoConta, saldo);
    }

    @Override
    public String toString() {
        return "ContaDTO{" +
                "id=" + id +
                ", idBanco=" + idBanco +
                ", nomeBanco='" + nomeBanco + '\'' +
                ", codigoUsuario=" + codigoUsuario +
                ", codigoTipoConta=" + codigoTipoConta +
                ", saldo=" + saldo +
                '}';
    }
}
