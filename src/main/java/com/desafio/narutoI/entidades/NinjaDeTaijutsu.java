package com.desafio.narutoI.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.Random;

@Entity
@DiscriminatorValue("TAIJUTSU")
public class NinjaDeTaijutsu extends Personagem implements Ninja {

    @Override
    public void usarJutsu(String nomeJutsu, Personagem oponente) {
        Jutsu jutsu = getJutsus().get(nomeJutsu);

        if (jutsu == null) {
            System.out.println(getNome() + " não conhece o jutsu: " + nomeJutsu);
            return;
        }

        if (getChakra() < jutsu.getCustoChakra()) {
            System.out.println(getNome() + " não tem chakra suficiente para usar " + nomeJutsu);
            return;
        }

        setChakra(getChakra() - jutsu.getCustoChakra());
        System.out.println(getNome() + " atacou com " + nomeJutsu +
                ", causando " + jutsu.getDano() + " de dano!");

        ((Ninja) oponente).desviar(jutsu.getDano());
    }

    @Override
    public void desviar(int danoRecebido) {
        boolean desviou = new Random().nextBoolean();
        if (desviou) {
            System.out.println(getNome() + " desviou do ataque com técnica de Taijutsu!");
        } else {
            setVida(getVida() - danoRecebido);
            System.out.println(getNome() + " foi atingido e perdeu " + danoRecebido + " de vida!");
        }
    }
}