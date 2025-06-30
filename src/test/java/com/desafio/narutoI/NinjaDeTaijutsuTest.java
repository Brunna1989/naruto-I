package com.desafio.narutoI;

import com.desafio.narutoI.entidades.Jutsu;
import com.desafio.narutoI.entidades.NinjaDeTaijutsu;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

public class NinjaDeTaijutsuTest {

    @Test
    void testUsarJutsuComJutsuExistenteEChakraSuficiente() {
        NinjaDeTaijutsu ninja = new NinjaDeTaijutsu();
        ninja.setNome("Rock Lee");
        ninja.setChakra(100);
        ninja.setVida(100);

        Jutsu jutsu = new Jutsu(25, 15);
        HashMap<String, Jutsu> jutsus = new HashMap<>();
        jutsus.put("Lótus Primária", jutsu);
        ninja.setJutsus(jutsus);

        NinjaDeTaijutsu oponente = new NinjaDeTaijutsu();
        oponente.setNome("Neji");
        oponente.setChakra(100);
        oponente.setVida(100);

        ninja.usarJutsu("Lótus Primária", oponente);

        assertEquals(85, ninja.getChakra());
    }

    @Test
    void testUsarJutsuComJutsuInexistente() {
        NinjaDeTaijutsu ninja = new NinjaDeTaijutsu();
        ninja.setNome("Rock Lee");
        ninja.setChakra(100);
        ninja.setVida(100);

        ninja.setJutsus(new HashMap<>());

        NinjaDeTaijutsu oponente = new NinjaDeTaijutsu();
        oponente.setNome("Neji");
        oponente.setChakra(100);
        oponente.setVida(100);

        ninja.usarJutsu("Punho Suave", oponente);

        assertEquals(100, ninja.getChakra());
    }

    @Test
    void testUsarJutsuSemChakraSuficiente() {
        NinjaDeTaijutsu ninja = new NinjaDeTaijutsu();
        ninja.setNome("Rock Lee");
        ninja.setChakra(10);
        ninja.setVida(100);

        Jutsu jutsu = new Jutsu(25, 15);
        HashMap<String, Jutsu> jutsus = new HashMap<>();
        jutsus.put("Lótus Primária", jutsu);
        ninja.setJutsus(jutsus);

        NinjaDeTaijutsu oponente = new NinjaDeTaijutsu();
        oponente.setNome("Neji");
        oponente.setChakra(100);
        oponente.setVida(100);

        ninja.usarJutsu("Lótus Primária", oponente);

        assertEquals(10, ninja.getChakra());
    }

    @Test
    void testDesviarDanoRecebido() {
        NinjaDeTaijutsu ninja = new NinjaDeTaijutsu();
        ninja.setNome("Rock Lee");
        ninja.setVida(100);

        int vidaAntes = ninja.getVida();
        ninja.desviar(20);
        assertTrue(ninja.getVida() == vidaAntes || ninja.getVida() == vidaAntes - 20);
    }
}