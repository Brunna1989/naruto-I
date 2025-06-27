package com.desafio.narutoI.services;

import com.desafio.narutoI.entidades.Personagem;
import com.desafio.narutoI.repositories.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BatalhaService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public String iniciarBatalha(Long idAtacante,String nomeJutsu,Long idDefensor) {
        Optional<Personagem>atacanteOpt = personagemRepository.findByid(idAtacante);
        Optional<Personagem>defensorOpt = personagemRepository.findById(idDefensor);

        if (atacanteOpt.isEmpty() || defensorOpt.isEmpty()) {
            return "Atacante ou defensor não encontrado.";
        }

        Personagem atacante = atacanteOpt.get();
        Personagem defensor = defensorOpt.get();

        if (atacante)
    }




}
