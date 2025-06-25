package com.desafio.narutoI.controller;

import com.desafio.narutoI.dto.PersonagemDTO;
import com.desafio.narutoI.services.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @PostMapping
    public ResponseEntity<PersonagemDTO> criar(@RequestBody PersonagemDTO dto) {
        PersonagemDTO salvo = personagemService.salvar(dto);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<PersonagemDTO>> listarTodos() {
        return ResponseEntity.ok(personagemService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemDTO> buscarPorId(@PathVariable Long id) {
        return personagemService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonagemDTO> atualizar(@PathVariable Long id, @RequestBody PersonagemDTO dto) {
        return personagemService.atualizar(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (personagemService.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}