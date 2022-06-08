package com.dio.f1rst.bankline.api.dto;

import com.dio.f1rst.bankline.api.model.MovimentacaoTipo;

public class NovaMovimentacaoDto {
    private String descricao;
    private Double valor;
    private MovimentacaoTipo tipo;
    private Integer id_conta;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public MovimentacaoTipo getTipo() {
        return tipo;
    }

    public void setTipo(MovimentacaoTipo tipo) {
        this.tipo = tipo;
    }

    public Integer getId_conta() {
        return id_conta;
    }

    public void setId_conta(Integer id_conta) {
        this.id_conta = id_conta;
    }

}
