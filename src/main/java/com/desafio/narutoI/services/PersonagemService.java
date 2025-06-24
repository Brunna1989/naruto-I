package com.desafio.narutoI.services;

import com.desafio.narutoI.dto.PersonagemDTO;
import com.desafio.narutoI.entidades.Personagem;
import com.desafio.narutoI.mapper.PersonagemMapper;
import com.desafio.narutoI.repositories.PersonagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonagemService {

    private final PersonagemRepository personagemRepository;
    private final PersonagemMapper personagemMapper;


    public List<PersonagemDTO> findAll() {
        return personagemRepository.findAll().stream()
                .map(personagemMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonagemDTO findById(Long id) {
        Personagem personagem = personagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado com ID: " + id));
        return personagemMapper.toDTO(personagem);
    }

    public PersonagemDTO save(PersonagemDTO personagemDTO) {
        Personagem personagem = personagemMapper.toEntity(personagemDTO);
        Personagem saved = personagemRepository.save(personagem);
        return personagemMapper.toDTO(saved);
    }

    public PersonagemDTO update(Long id, PersonagemDTO personagemDTO) {
        Optional<Personagem> existing = personagemRepository.findById(id);
        if (existing.isEmpty()) {
            throw new RuntimeException("Personagem não encontrado com ID: " + id);
        }
        Personagem personagem = personagemMapper.toEntity(personagemDTO);
        personagem.setId(id);
        Personagem updated = personagemRepository.save(personagem);
        return personagemMapper.toDTO(updated);
    }

    public void delete(Long id) {
        if (!personagemRepository.existsById(id)) {
            throw new RuntimeException("Personagem não encontrado com ID: " + id);
        }
        personagemRepository.deleteById(id);
    }
}
