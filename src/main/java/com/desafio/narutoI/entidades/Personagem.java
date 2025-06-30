package com.desafio.narutoI.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.Map;

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
    private int chakra = 100;
    private int vida;

    @ElementCollection
    @CollectionTable(name = "personagem_jutsus", joinColumns = @JoinColumn(name = "personagem_id"))
    @MapKeyColumn(name = "nome_jutsu")
    private Map<String, Jutsu> jutsus = new HashMap<>();
}