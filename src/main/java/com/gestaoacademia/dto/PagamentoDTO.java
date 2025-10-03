package com.gestaoacademia.dto;

import com.gestaoacademia.model.StatusPagamento;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PagamentoDTO {
    private Long id;
    private LocalDate dataPagamento;
    private BigDecimal valor;
    private StatusPagamento status;
    private Long alunoId;
    private String alunoNome;

    public PagamentoDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(LocalDate dataPagamento) { this.dataPagamento = dataPagamento; }
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
    public StatusPagamento getStatus() { return status; }
    public void setStatus(StatusPagamento status) { this.status = status; }
    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }
    public String getAlunoNome() { return alunoNome; }
    public void setAlunoNome(String alunoNome) { this.alunoNome = alunoNome; }
}