package com.desafio.narutoI;

import com.desafio.narutoI.entidades.Jutsu;
import com.desafio.narutoI.entidades.Personagem;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class PersonagemTest {

   public static class PersonagemConcreto extends Personagem {}

    @Test
    void testSetAndGetNome() {
        Personagem personagem = new PersonagemConcreto();
        personagem.setNome("Kakashi");
        assertEquals("Kakashi", personagem.getNome());
    }

    @Test
    void testSetAndGetChakra() {
        Personagem personagem = new PersonagemConcreto();
        personagem.setChakra(80);
        assertEquals(80, personagem.getChakra());
    }

    @Test
    void testSetAndGetVida() {
        Personagem personagem = new PersonagemConcreto();
        personagem.setVida(120);
        assertEquals(120, personagem.getVida());
    }

    @Test
    void testSetAndGetJutsus() {
        Personagem personagem = new PersonagemConcreto();
        Map<String, Jutsu> jutsus = new HashMap<>();
        jutsus.put("Sharingan", new Jutsu(40, 20));
        personagem.setJutsus(jutsus);
        assertEquals(1, personagem.getJutsus().size());
        assertTrue(personagem.getJutsus().containsKey("Sharingan"));
        assertEquals(40, personagem.getJutsus().get("Sharingan").getDano());
        assertEquals(20, personagem.getJutsus().get("Sharingan").getCustoChakra());
    }

    @Test
    void testDefaultChakraValue() {
        Personagem personagem = new PersonagemConcreto();
        assertEquals(100, personagem.getChakra());
    }

    @Test
    void testDefaultJutsusMapIsNotNull() {
        Personagem personagem = new PersonagemConcreto();
        assertNotNull(personagem.getJutsus());
        assertTrue(personagem.getJutsus().isEmpty());
    }
}