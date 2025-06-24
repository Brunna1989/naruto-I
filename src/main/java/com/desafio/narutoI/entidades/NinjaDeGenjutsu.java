package com.desafio.narutoI.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("GENJUTSU")
public class NinjaDeGenjutsu extends Personagem implements Ninja {

    @Override
    public void usarJutsu() {
        System.out.println(getNome() + " está usando um jutsu de Genjutsu!");
    }

    @Override
    public void desviar() {
        System.out.println(getNome() + " está desviando de um ataque usando Genjutsu!");
    }
}
