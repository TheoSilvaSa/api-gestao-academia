package com.gestaoacademia.service;

import com.gestaoacademia.dto.TreinoDTO;
import com.gestaoacademia.model.Aluno;
import com.gestaoacademia.model.Treino;
import com.gestaoacademia.repository.AlunoRepository;
import com.gestaoacademia.repository.TreinoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreinoService {
    @Autowired
    private TreinoRepository treinoRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    public TreinoDTO criarTreino(TreinoDTO treinoDTO) {
        Treino treino = new Treino();
        treino.setNome(treinoDTO.getNome());
        treino.setDescricao(treinoDTO.getDescricao());
        treino = treinoRepository.save(treino);
        return toDTO(treino);
    }

    public List<TreinoDTO> listarTodos() {
        return treinoRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public void deletarTreino(Long id) {
        Treino treino = treinoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Treino não encontrado com id: " + id));

        if (!treino.getAlunos().isEmpty()) {
            throw new IllegalStateException("Não é possível remover um treino que está associado a alunos.");
        }
        treinoRepository.deleteById(id);
    }

    public void associarAluno(Long treinoId, Long alunoId) {
        Treino treino = treinoRepository.findById(treinoId)
                .orElseThrow(() -> new EntityNotFoundException("Treino não encontrado com id: " + treinoId));
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado com id: " + alunoId));
        aluno.getTreinos().add(treino);
        alunoRepository.save(aluno);
    }

    private TreinoDTO toDTO(Treino treino) {
        TreinoDTO dto = new TreinoDTO();
        dto.setId(treino.getId());
        dto.setNome(treino.getNome());
        dto.setDescricao(treino.getDescricao());
        if(treino.getAlunos() != null) {
            dto.setAlunosIds(treino.getAlunos().stream().map(Aluno::getId).collect(Collectors.toList()));
        }
        return dto;
    }

    public TreinoDTO atualizarTreino(Long id, TreinoDTO treinoDTO) {
        Treino treino = treinoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Treino não encontrado com id: " + id));

        treino.setNome(treinoDTO.getNome());
        treino.setDescricao(treinoDTO.getDescricao());

        Treino treinoAtualizado = treinoRepository.save(treino);
        return toDTO(treinoAtualizado);
    }
}