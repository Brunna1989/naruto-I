package com.desafio.narutoI.dto;

import com.desafio.narutoI.entidades.Jutsu;
import lombok.Data;
import java.util.Map;

@Data
public class PersonagemDTO {
    private Long id;
    private String nome;
    private int chakra;
    private String vida;

    private Map<String, Jutsu> jutsus;
    private String tipoNinja;
}