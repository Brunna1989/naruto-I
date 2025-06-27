package com.desafio.narutoI;

import com.desafio.narutoI.entidades.Jutsu;
import com.desafio.narutoI.entidades.NinjaDeNinjutsu;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

public class NinjaDeNinjutsuTest {

    @Test
    void testUsarJutsuComJutsuExistenteEChakraSuficiente() {
        NinjaDeNinjutsu ninja = new NinjaDeNinjutsu();
        ninja.setNome("Naruto");
        ninja.setChakra(100);
        ninja.setVida(100);

        Jutsu jutsu = new Jutsu(30, 20);
        HashMap<String, Jutsu> jutsus = new HashMap<>();
        jutsus.put("Rasengan", jutsu);
        ninja.setJutsus(jutsus);

        NinjaDeNinjutsu oponente = new NinjaDeNinjutsu();
        oponente.setNome("Sasuke");
        oponente.setChakra(100);
        oponente.setVida(100);

        ninja.usarJutsu("Rasengan", oponente);

        assertEquals(80, ninja.getChakra());
    }

    @Test
    void testUsarJutsuComJutsuInexistente() {
        NinjaDeNinjutsu ninja = new NinjaDeNinjutsu();
        ninja.setNome("Naruto");
        ninja.setChakra(100);
        ninja.setVida(100);

        ninja.setJutsus(new HashMap<>());

        NinjaDeNinjutsu oponente = new NinjaDeNinjutsu();
        oponente.setNome("Sasuke");
        oponente.setChakra(100);
        oponente.setVida(100);

        ninja.usarJutsu("Chidori", oponente);

        assertEquals(100, ninja.getChakra());
    }

    @Test
    void testUsarJutsuSemChakraSuficiente() {
        NinjaDeNinjutsu ninja = new NinjaDeNinjutsu();
        ninja.setNome("Naruto");
        ninja.setChakra(10);
        ninja.setVida(100);

        Jutsu jutsu = new Jutsu(30, 20);
        HashMap<String, Jutsu> jutsus = new HashMap<>();
        jutsus.put("Rasengan", jutsu);
        ninja.setJutsus(jutsus);

        NinjaDeNinjutsu oponente = new NinjaDeNinjutsu();
        oponente.setNome("Sasuke");
        oponente.setChakra(100);
        oponente.setVida(100);

        ninja.usarJutsu("Rasengan", oponente);

        assertEquals(10, ninja.getChakra());
    }

    @Test
    void testDesviarDanoRecebido() {
        NinjaDeNinjutsu ninja = new NinjaDeNinjutsu();
        ninja.setNome("Naruto");
        ninja.setVida(100);

        int vidaAntes = ninja.getVida();
        ninja.desviar(20);
        assertTrue(ninja.getVida() == vidaAntes || ninja.getVida() == vidaAntes - 20);
    }
}