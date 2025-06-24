package com.desafio.narutoI.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("NINJUTSU")
public class NinjaDeNinjutsu extends Personagem implements Ninja {

    @Override
    public void usarJutsu() {
        System.out.println(getNome() + " está usando um jutsu de Ninjutsu!");
    }

    @Override
    public void desviar() {
        System.out.println(getNome() + " está desviando de um ataque usando Ninjutsu!");
    }
}
