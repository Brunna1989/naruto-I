package com.desafio.narutoI.controller;

import com.desafio.narutoI.entidades.Ninja;
import com.desafio.narutoI.repositories.NinjaDeNinjutsuRepository;
import com.desafio.narutoI.repositories.NinjaDeTaijutsuRepository;
import com.desafio.narutoI.services.BatalhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/batalha")
public class BatalhaController {

    @Autowired
    private NinjaDeTaijutsuRepository taijutsuRepository;

    @Autowired
    private NinjaDeNinjutsuRepository ninjutsuRepository;

    @Autowired
    private BatalhaService batalhaService;

    @PostMapping("/iniciar")
    public String iniciarBatalha(
            @RequestParam("id1") Long id1,
            @RequestParam("tipo1") String tipo1,
            @RequestParam("id2") Long id2,
            @RequestParam("tipo2") String tipo2
    ) {
        Ninja ninja1 = buscarNinjaPorTipoEId(tipo1, id1);
        Ninja ninja2 = buscarNinjaPorTipoEId(tipo2, id2);

        if (ninja1 == null || ninja2 == null) {
            return "Um ou ambos os ninjas não foram encontrados.";
        }

        return batalhaService.iniciarBatalha(ninja1, ninja2);
    }

    private Ninja buscarNinjaPorTipoEId(String tipo, Long id) {
        if ("TAIJUTSU".equalsIgnoreCase(tipo)) {
            return taijutsuRepository.findById(id).orElse(null);
        } else if ("NINJUTSU".equalsIgnoreCase(tipo)) {
            return ninjutsuRepository.findById(id).orElse(null);
        }
        return null;
    }
}