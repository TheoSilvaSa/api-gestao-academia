package com.gestaoacademia.controller;

import com.gestaoacademia.dto.TreinoDTO;
import com.gestaoacademia.service.TreinoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/treinos")
@Tag(name = "Treinos", description = "Endpoints Treinos")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    @PostMapping
    public ResponseEntity<TreinoDTO> criarTreino(@RequestBody TreinoDTO treinoDTO) {
        TreinoDTO novoTreino = treinoService.criarTreino(treinoDTO);
        return new ResponseEntity<>(novoTreino, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TreinoDTO>> listarTreinos() {
        return ResponseEntity.ok(treinoService.listarTodos());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarTreino(@PathVariable Long id) {
        treinoService.deletarTreino(id);
    }

    @PostMapping("/{treinoId}/alunos/{alunoId}")
    @ResponseStatus(HttpStatus.OK)
    public void associarAlunoAoTreino(@PathVariable Long treinoId, @PathVariable Long alunoId) {
        treinoService.associarAluno(treinoId, alunoId);
    }
}