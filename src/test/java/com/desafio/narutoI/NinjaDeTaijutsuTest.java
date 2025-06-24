package com.desafio.narutoI;

import com.desafio.narutoI.entidades.NinjaDeTaijutsu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NinjaDeTaijutsuTest {

    private NinjaDeTaijutsu ninja;

    @BeforeEach
    void setUp() {
        ninja = new NinjaDeTaijutsu();
        ninja.setNome("Rock Lee");
        ninja.setIdade(17);
        ninja.setAldeia("Konoha");
        ninja.setChakra(100);
    }

    @Test
    void testAdicionarJutsu() {
        ninja.getJutsus().add("Konoha Senpuu");
        assertTrue(ninja.getJutsus().contains("Konoha Senpuu"));
    }

    @Test
    void testAumentarChakra() {
        int chakraInicial = ninja.getChakra();
        ninja.setChakra(chakraInicial + 50);
        assertEquals(chakraInicial + 50, ninja.getChakra());
    }

    @Test
    void testExibirInformacoes() {
        ninja.getJutsus().add("Konoha Senpuu");
        String info = String.format(
                "Nome: %s, Idade: %d, Aldeia: %s, Chakra: %d, Jutsus: %s",
                ninja.getNome(), ninja.getIdade(), ninja.getAldeia(), ninja.getChakra(), ninja.getJutsus()
        );
        assertTrue(info.contains("Rock Lee"));
        assertTrue(info.contains("Konoha Senpuu"));
    }

    @Test
    void testUsarJutsu() {
        ninja.usarJutsu();
    }

    @Test
    void testDesviar() {
        ninja.desviar();
    }
}