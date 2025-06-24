package com.desafio.narutoI.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TAIJUTSU")
public class NinjaDeTaijutsu extends Personagem implements Ninja {

    @Override
    public void usarJutsu() {
        System.out.println(getNome() + " está usando um golpe de Taijutsu!");
    }

    @Override
    public void desviar() {
        System.out.println(getNome() + " está desviando de um ataque usando Taijutsu!");
    }
}
