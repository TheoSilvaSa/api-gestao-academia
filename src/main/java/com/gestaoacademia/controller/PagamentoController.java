package com.gestaoacademia.controller;

import com.gestaoacademia.dto.PagamentoDTO;
import com.gestaoacademia.service.PagamentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Pagamentos", description = "Endpoints Pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/alunos/{alunoId}/pagamentos")
    public ResponseEntity<List<PagamentoDTO>> listarPagamentosDoAluno(@PathVariable Long alunoId) {
        return ResponseEntity.ok(pagamentoService.listarPagamentosPorAluno(alunoId));
    }

    @PostMapping("/alunos/{alunoId}/pagamentos")
    public ResponseEntity<PagamentoDTO> registrarPagamento(@PathVariable Long alunoId) {
        PagamentoDTO novoPagamento = pagamentoService.registrarPagamento(alunoId);
        return new ResponseEntity<>(novoPagamento, HttpStatus.CREATED);
    }
}