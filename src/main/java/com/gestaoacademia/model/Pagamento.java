package com.gestaoacademia.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataPagamento;
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    public Pagamento() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(LocalDate dataPagamento) { this.dataPagamento = dataPagamento; }
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
    public StatusPagamento getStatus() { return status; }
    public void setStatus(StatusPagamento status) { this.status = status; }
    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}