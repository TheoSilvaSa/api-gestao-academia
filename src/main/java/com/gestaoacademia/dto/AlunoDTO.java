package com.gestaoacademia.dto;

import java.time.LocalDate;
import java.util.List;

public class AlunoDTO {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private boolean ativo;
    private Long planoId;
    private String planoNome;
    private List<Long> treinosIds;

    public AlunoDTO() {}

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
    public Long getPlanoId() { return planoId; }
    public void setPlanoId(Long planoId) { this.planoId = planoId; }
    public String getPlanoNome() { return planoNome; }
    public void setPlanoNome(String planoNome) { this.planoNome = planoNome; }
    public List<Long> getTreinosIds() { return treinosIds; }
    public void setTreinosIds(List<Long> treinosIds) { this.treinosIds = treinosIds; }
}