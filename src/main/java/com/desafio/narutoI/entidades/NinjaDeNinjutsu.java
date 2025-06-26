package com.desafio.narutoI.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Random;

@Entity
@DiscriminatorValue("NINJUTSU")
public class NinjaDeNinjutsu extends Personagem implements Ninja {

    @Override
    public void usarJutsu(String nomeJutsu, Personagem oponente) {
        Jutsu jutsu = getJutsus().get(nomeJutsu);
        if (jutsu == null) {
            System.out.println(getNome() + " não conhece o jutsu: " + nomeJutsu);
            return;
        }
        if (getChakra() < jutsu.getConsumoDeChakra()) {
            System.out.println(getNome() + " não tem chakra suficiente para usar " + nomeJutsu);
            return;
        }

        setChakra(getChakra() - jutsu.getConsumoDeChakra());
        System.out.println(getNome() + " lançou um jutsu de Ninjutsu: " + nomeJutsu + ", causando " + jutsu.getDano() + " de dano!");
        oponente.desviar(jutsu.getDano());
    }

    @Override
    public void desviar(int danoRecebido) {
        boolean desviou = new Random().nextBoolean();
        if (desviou) {
            System.out.println(getNome() + " desviou com ninjutsu defensivo!");
        } else {
            setVida(getVida() - danoRecebido);
            System.out.println(getNome() + " recebeu o ataque e perdeu " + danoRecebido + " de vida!");
        }
    }


}

