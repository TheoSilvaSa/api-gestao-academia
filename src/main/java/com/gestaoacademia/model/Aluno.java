package com.gestaoacademia.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private boolean ativo = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plano_id")
    private Plano plano;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pagamento> pagamentos = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "aluno_treino_vinculo",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "treino_id"))
    private List<Treino> treinos = new ArrayList<>();

    public Aluno() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
    public Plano getPlano() { return plano; }
    public void setPlano(Plano plano) { this.plano = plano; }
    public List<Pagamento> getPagamentos() { return pagamentos; }
    public void setPagamentos(List<Pagamento> pagamentos) { this.pagamentos = pagamentos; }
    public List<Treino> getTreinos() { return treinos; }
    public void setTreinos(List<Treino> treinos) { this.treinos = treinos; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}