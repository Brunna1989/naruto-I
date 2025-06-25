// src/main/java/com/desafio/narutoI/controller/PersonagemController.java
package com.desafio.narutoI.controller;

import com.desafio.narutoI.dto.PersonagemDTO;
import com.desafio.narutoI.services.PersonagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/personagens")
@RequiredArgsConstructor
public class PersonagemController {

    private final PersonagemService personagemService;

    @GetMapping
    public ResponseEntity<List<PersonagemDTO>> getAll() {
        return ResponseEntity.ok(personagemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(personagemService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PersonagemDTO> create(@RequestBody PersonagemDTO dto) {
        return ResponseEntity.ok(personagemService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonagemDTO> update(@PathVariable Long id, @RequestBody PersonagemDTO dto) {
        return ResponseEntity.ok(personagemService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personagemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}