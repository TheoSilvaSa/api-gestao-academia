package com.gestaoacademia.dto;

import java.math.BigDecimal;

public class PlanoDTO {
    private Long id;
    private String nome;
    private BigDecimal valor;

    public PlanoDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
}