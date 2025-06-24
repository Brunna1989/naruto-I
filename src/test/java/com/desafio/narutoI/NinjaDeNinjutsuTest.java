package com.desafio.narutoI;

import com.desafio.narutoI.entidades.NinjaDeNinjutsu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NinjaDeNinjutsuTest {

    private NinjaDeNinjutsu ninja;

    @BeforeEach
    void setUp() {
        ninja = new NinjaDeNinjutsu();
        ninja.setNome("Kakashi Hatake");
        ninja.setIdade(30);
        ninja.setAldeia("Konoha");
        ninja.setChakra(120);
    }

    @Test
    void testAdicionarJutsu() {
        ninja.getJutsus().add("Chidori");
        assertTrue(ninja.getJutsus().contains("Chidori"));
    }

    @Test
    void testAumentarChakra() {
        int chakraInicial = ninja.getChakra();
        ninja.setChakra(chakraInicial + 80);
        assertEquals(chakraInicial + 80, ninja.getChakra());
    }

    @Test
    void testExibirInformacoes() {
        ninja.getJutsus().add("Raikiri");
        String info = String.format(
                "Nome: %s, Idade: %d, Aldeia: %s, Chakra: %d, Jutsus: %s",
                ninja.getNome(), ninja.getIdade(), ninja.getAldeia(), ninja.getChakra(), ninja.getJutsus()
        );
        assertTrue(info.contains("Kakashi Hatake"));
        assertTrue(info.contains("Raikiri"));
    }
}