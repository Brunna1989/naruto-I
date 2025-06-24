package com.desafio.narutoI.dto;

import lombok.Data;

import java.util.List;

@Data
public class PersonagemDTO {

    private Long id;
    private String nome;
    private int idade;
    private String aldeia;
    private int chakra;
    private List<String> jutsus;
}
