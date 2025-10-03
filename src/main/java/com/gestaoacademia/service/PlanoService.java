package com.gestaoacademia.service;

import com.gestaoacademia.dto.PlanoDTO;
import com.gestaoacademia.model.Plano;
import com.gestaoacademia.repository.PlanoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    public PlanoDTO criarPlano(PlanoDTO planoDTO) {
        Plano plano = new Plano();
        plano.setNome(planoDTO.getNome());
        plano.setValor(planoDTO.getValor());
        plano = planoRepository.save(plano);
        return toDTO(plano);
    }

    public List<PlanoDTO> listarTodos() {
        return planoRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public void deletarPlano(Long id) {
        if (!planoRepository.existsById(id)) {
            throw new EntityNotFoundException("Plano com id " + id + " não encontrado.");
        }
        planoRepository.deleteById(id);
    }

    private PlanoDTO toDTO(Plano plano) {
        PlanoDTO dto = new PlanoDTO();
        dto.setId(plano.getId());
        dto.setNome(plano.getNome());
        dto.setValor(plano.getValor());
        return dto;
    }
}