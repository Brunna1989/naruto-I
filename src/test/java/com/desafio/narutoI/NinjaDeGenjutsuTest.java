package com.desafio.narutoI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NinjaDeGenjutsuTest {

    private NinjaDeGenjutsu ninja;

    @BeforeEach
    void setUp() {
        ninja = new NinjaDeGenjutsu();
        ninja.setNome("Kurenai Yuhi");
        ninja.setIdade(27);
        ninja.setAldeia("Konoha");
        ninja.setChakra(110);
    }

    @Test
    void testGettersAndSetters() {
        ninja.setId(1L);
        assertEquals(1L, ninja.getId());
        assertEquals("Kurenai Yuhi", ninja.getNome());
        assertEquals(27, ninja.getIdade());
        assertEquals("Konoha", ninja.getAldeia());
        assertEquals(110, ninja.getChakra());
    }

    @Test
    void testAdicionarJutsu() {
        ninja.getJutsus().add("Magen: Jubaku Satsu");
        assertTrue(ninja.getJutsus().contains("Magen: Jubaku Satsu"));
    }

    @Test
    void testJutsusList() {
        assertNotNull(ninja.getJutsus());
        assertTrue(ninja.getJutsus().isEmpty());
        ninja.getJutsus().add("Genjutsu Básico");
        assertEquals(1, ninja.getJutsus().size());
    }

    @Test
    void testUsarJutsu() {
        ninja.usarJutsu();
    }

    @Test
    void testDesviar() {
        ninja.desviar();
    }

    @Test
    void testEqualsAndHashCode() {
        NinjaDeGenjutsu ninja2 = new NinjaDeGenjutsu();
        ninja2.setId(1L);
        ninja2.setNome("Kurenai Yuhi");
        ninja2.setIdade(27);
        ninja2.setAldeia("Konoha");
        ninja2.setChakra(110);

        ninja.setId(1L);

        assertEquals(ninja, ninja2);
        assertEquals(ninja.hashCode(), ninja2.hashCode());
    }

    @Test
    void testToString() {
        String str = ninja.toString();
        assertTrue(str.contains("Kurenai Yuhi"));
        assertTrue(str.contains("Konoha"));
    }
}