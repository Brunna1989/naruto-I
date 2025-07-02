package com.desafio.narutoI.services;

import com.desafio.narutoI.entidades.Jutsu;
import com.desafio.narutoI.entidades.Ninja;
import com.desafio.narutoI.entidades.Personagem;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class BatalhaService {

    private final Random random = new Random();

    public String iniciarBatalha(Ninja p1, Ninja p2) {
        Ninja atacante = p1;
        Ninja defensor = p2;

        while (((Personagem) atacante).getVida() > 0 && ((Personagem) defensor).getVida() > 0) {
            Personagem atacantePers = (Personagem) atacante;
            if (!atacantePers.getJutsus().isEmpty() && atacantePers.getChakra() > 0) {
                String nomeJutsu = escolherJutsuAleatorio(atacantePers.getJutsus());
                atacante.usarJutsu(nomeJutsu, (Personagem) defensor);
            }
            if (((Personagem) defensor).getVida() <= 0 || atacantePers.getChakra() <= 0) break;

            Ninja temp = atacante;
            atacante = defensor;
            defensor = temp;
        }

        if (((Personagem) p1).getVida() > 0) {
            return ((Personagem) p1).getNome() + " venceu a batalha!";
        } else if (((Personagem) p2).getVida() > 0) {
            return ((Personagem) p2).getNome() + " venceu a batalha!";
        } else {
            return "Empate! Ambos os ninjas foram derrotados.";
        }
    }

    private String escolherJutsuAleatorio(Map<String, Jutsu> jutsus) {
        List<String> nomes = jutsus.keySet().stream().toList();
        return nomes.get(random.nextInt(nomes.size()));
    }
}