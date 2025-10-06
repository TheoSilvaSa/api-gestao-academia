package com.gestaoacademia.service;

import com.gestaoacademia.dto.AlunoDTO;
import com.gestaoacademia.model.Aluno;
import com.gestaoacademia.repository.AlunoRepository;
import com.gestaoacademia.repository.PlanoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private PlanoRepository planoRepository;

    public AlunoDTO criarAluno(AlunoDTO alunoDTO) {
        alunoRepository.findByCpf(alunoDTO.getCpf()).ifPresent(a -> {
            throw new IllegalArgumentException("Erro: CPF duplicado");
        });
        Aluno aluno = toEntity(alunoDTO);
        aluno = alunoRepository.save(aluno);
        return toDTO(aluno);
    }

    public List<AlunoDTO> listarTodos() {
        return alunoRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public void inativarAluno(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado com id: " + id));
        aluno.setAtivo(false);
        alunoRepository.save(aluno);
    }

    private Aluno toEntity(AlunoDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setCpf(dto.getCpf());
        aluno.setDataNascimento(dto.getDataNascimento());
        aluno.setAtivo(true);
        if (dto.getPlanoId() != null) {
            aluno.setPlano(planoRepository.findById(dto.getPlanoId())
                    .orElseThrow(() -> new EntityNotFoundException("Plano não encontrado com id: " + dto.getPlanoId())));
        }
        return aluno;
    }

    private AlunoDTO toDTO(Aluno aluno) {
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setCpf(aluno.getCpf());
        dto.setDataNascimento(aluno.getDataNascimento());
        dto.setAtivo(aluno.isAtivo());
        if (aluno.getPlano() != null) {
            dto.setPlanoId(aluno.getPlano().getId());
            dto.setPlanoNome(aluno.getPlano().getNome());
        }
        return dto;
    }

    public AlunoDTO atualizarAluno(Long id, AlunoDTO alunoDTO) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado com id: " + id));

        aluno.setNome(alunoDTO.getNome());
        aluno.setDataNascimento(alunoDTO.getDataNascimento());

        if (alunoDTO.getPlanoId() != null) {
            aluno.setPlano(planoRepository.findById(alunoDTO.getPlanoId())
                    .orElseThrow(() -> new EntityNotFoundException("Plano não encontrado com id: " + alunoDTO.getPlanoId())));
        }

        Aluno alunoAtualizado = alunoRepository.save(aluno);
        return toDTO(alunoAtualizado);
    }
}