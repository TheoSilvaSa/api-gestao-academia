package com.gestaoacademia.controller;

import com.gestaoacademia.dto.PlanoDTO;
import com.gestaoacademia.service.PlanoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/planos")
@Tag(name = "Planos", description = "Endpoints Planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @PostMapping
    public ResponseEntity<PlanoDTO> criarPlano(@RequestBody PlanoDTO planoDTO) {
        PlanoDTO novoPlano = planoService.criarPlano(planoDTO);
        return new ResponseEntity<>(novoPlano, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlanoDTO>> listarPlanos() {
        return ResponseEntity.ok(planoService.listarTodos());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPlano(@PathVariable Long id) {
        planoService.deletarPlano(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoDTO> atualizarPlano(@PathVariable Long id, @RequestBody PlanoDTO planoDTO) {
        PlanoDTO planoAtualizado = planoService.atualizarPlano(id, planoDTO);
        return ResponseEntity.ok(planoAtualizado);
    }
}