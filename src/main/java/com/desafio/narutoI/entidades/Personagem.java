package com.desafio.narutoI.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_ninja")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private String aldeia;
    private int chakra;

    @ElementCollection
    private List<String> jutsus = new ArrayList<>();
}