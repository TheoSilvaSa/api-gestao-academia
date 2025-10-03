package com.gestaoacademia.service;

import com.gestaoacademia.dto.PagamentoDTO;
import com.gestaoacademia.model.Aluno;
import com.gestaoacademia.model.Pagamento;
import com.gestaoacademia.model.StatusPagamento;
import com.gestaoacademia.repository.AlunoRepository;
import com.gestaoacademia.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    public List<PagamentoDTO> listarPagamentosPorAluno(Long alunoId) {
        if (!alunoRepository.existsById(alunoId)) {
            throw new EntityNotFoundException("Aluno não encontrado com id: " + alunoId);
        }
        return pagamentoRepository.findAll().stream()
                .filter(p -> p.getAluno().getId().equals(alunoId))
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PagamentoDTO registrarPagamento(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado com id: " + alunoId));

        if (aluno.getPlano() == null) {
            throw new IllegalStateException("Aluno não possui um plano ativo para registrar pagamento.");
        }

        Pagamento pagamento = new Pagamento();
        pagamento.setAluno(aluno);
        pagamento.setDataPagamento(LocalDate.now());
        pagamento.setValor(aluno.getPlano().getValor());
        pagamento.setStatus(StatusPagamento.PAGO);

        pagamento = pagamentoRepository.save(pagamento);
        return toDTO(pagamento);
    }

    private PagamentoDTO toDTO(Pagamento pagamento) {
        PagamentoDTO dto = new PagamentoDTO();
        dto.setId(pagamento.getId());
        dto.setDataPagamento(pagamento.getDataPagamento());
        dto.setValor(pagamento.getValor());
        dto.setStatus(pagamento.getStatus());
        dto.setAlunoId(pagamento.getAluno().getId());
        dto.setAlunoNome(pagamento.getAluno().getNome());
        return dto;
    }
}