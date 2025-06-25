package com.desafio.narutoI.services;

import com.desafio.narutoI.dto.PersonagemDTO;
import com.desafio.narutoI.entidades.*;
import com.desafio.narutoI.repositories.PersonagemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public PersonagemDTO salvar(PersonagemDTO dto) {
        Personagem personagem = converterDTOParaEntidade(dto);
        personagem = personagemRepository.save(personagem);
        return converterEntidadeParaDTO(personagem);
    }

    public List<PersonagemDTO> listarTodos() {
        return personagemRepository.findAll()
                .stream()
                .map(this::converterEntidadeParaDTO)
                .collect(Collectors.toList());
    }

    public Optional<PersonagemDTO> buscarPorId(Long id) {
        return personagemRepository.findById(id)
                .map(this::converterEntidadeParaDTO);
    }

    public Optional<PersonagemDTO> atualizar(Long id, PersonagemDTO dto) {
        return personagemRepository.findById(id).map(personagemExistente -> {
            Personagem personagemAtualizado = converterDTOParaEntidade(dto);
            personagemAtualizado.setId(id);
            personagemAtualizado = personagemRepository.save(personagemAtualizado);
            return converterEntidadeParaDTO(personagemAtualizado);
        });
    }

    public boolean deletar(Long id) {
        if (personagemRepository.existsById(id)) {
            personagemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private Personagem converterDTOParaEntidade(PersonagemDTO dto) {
        if (dto.getTipoNinja() == null) {
            throw new IllegalArgumentException("Tipo de ninja não pode ser nulo");
        }
        switch (dto.getTipoNinja().toUpperCase()) {
            case "NINJUTSU":
                return objectMapper.convertValue(dto, NinjaDeNinjutsu.class);
            case "GENJUTSU":
                return objectMapper.convertValue(dto, NinjaDeGenjutsu.class);
            case "TAIJUTSU":
                return objectMapper.convertValue(dto, NinjaDeTaijutsu.class);
            default:
                throw new IllegalArgumentException("Tipo de ninja inválido: " + dto.getTipoNinja());
        }
    }

    private PersonagemDTO converterEntidadeParaDTO(Personagem personagem) {
        PersonagemDTO dto = objectMapper.convertValue(personagem, PersonagemDTO.class);
        if (personagem instanceof NinjaDeNinjutsu) {
            dto.setTipoNinja("NINJUTSU");
        } else if (personagem instanceof NinjaDeGenjutsu) {
            dto.setTipoNinja("GENJUTSU");
        } else if (personagem instanceof NinjaDeTaijutsu) {
            dto.setTipoNinja("TAIJUTSU");
        }
        return dto;
    }
}