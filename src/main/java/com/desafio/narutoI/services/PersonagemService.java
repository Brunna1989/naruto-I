package com.desafio.narutoI.services;

import com.desafio.narutoI.dto.PersonagemDTO;
import com.desafio.narutoI.mapper.PersonagemMapper;
import com.desafio.narutoI.repositories.PersonagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
