package com.desafio.narutoI;

import com.desafio.narutoI.entidades.NinjaDeNinjutsu;
import org.junit.jupiter.api.BeforeEach;


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
}