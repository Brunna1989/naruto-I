package com.desafio.narutoI;

import com.desafio.narutoI.dto.PersonagemDTO;
import com.desafio.narutoI.entidades.NinjaDeNinjutsu;
import com.desafio.narutoI.entidades.Personagem;
import com.desafio.narutoI.repositories.PersonagemRepository;
import com.desafio.narutoI.services.PersonagemService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonagemServiceTest {

    private PersonagemRepository personagemRepository;
    private ObjectMapper objectMapper;
    private PersonagemService personagemService;

    @BeforeEach
    void setUp() throws Exception {
        personagemRepository = mock(PersonagemRepository.class);
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        personagemService = new PersonagemService();

        java.lang.reflect.Field repoField = PersonagemService.class.getDeclaredField("personagemRepository");
        repoField.setAccessible(true);
        repoField.set(personagemService, personagemRepository);

        java.lang.reflect.Field mapperField = PersonagemService.class.getDeclaredField("objectMapper");
        mapperField.setAccessible(true);
        mapperField.set(personagemService, objectMapper);
    }

    @Test
    void testSalvar() {
        PersonagemDTO dto = new PersonagemDTO();
        dto.setNome("Naruto");
        dto.setTipoNinja("NINJUTSU");

        NinjaDeNinjutsu personagem = new NinjaDeNinjutsu();
        personagem.setNome("Naruto");

        when(personagemRepository.save(any(Personagem.class))).thenReturn(personagem);

        PersonagemDTO result = personagemService.salvar(dto);

        assertNotNull(result);
        assertEquals("Naruto", result.getNome());
    }

    @Test
    void testListarTodos() {
        NinjaDeNinjutsu personagem = new NinjaDeNinjutsu();
        personagem.setNome("Naruto");
        when(personagemRepository.findAll()).thenReturn(Collections.singletonList(personagem));

        List<PersonagemDTO> result = personagemService.listarTodos();

        assertEquals(1, result.size());
        assertEquals("Naruto", result.get(0).getNome());
    }

    @Test
    void testBuscarPorIdFound() {
        NinjaDeNinjutsu personagem = new NinjaDeNinjutsu();
        personagem.setId(1L);
        personagem.setNome("Naruto");
        when(personagemRepository.findById(1L)).thenReturn(Optional.of(personagem));

        Optional<PersonagemDTO> result = personagemService.buscarPorId(1L);

        assertTrue(result.isPresent());
        assertEquals("Naruto", result.get().getNome());
    }

    @Test
    void testBuscarPorIdNotFound() {
        when(personagemRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<PersonagemDTO> result = personagemService.buscarPorId(1L);

        assertFalse(result.isPresent());
    }

    @Test
    void testAtualizarFound() {
        objectMapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        NinjaDeNinjutsu personagemExistente = new NinjaDeNinjutsu();
        personagemExistente.setId(1L);
        personagemExistente.setNome("Naruto"); // Adicione esta linha

        PersonagemDTO dto = new PersonagemDTO();
        dto.setNome("Naruto");
        dto.setTipoNinja("NINJUTSU");

        when(personagemRepository.findById(1L)).thenReturn(Optional.of(personagemExistente));
        when(personagemRepository.save(any(Personagem.class))).thenReturn(personagemExistente);

        Optional<PersonagemDTO> result = personagemService.atualizar(1L, dto);

        assertTrue(result.isPresent());
        assertEquals("Naruto", result.get().getNome());
    }

    @Test
    void testAtualizarNotFound() {
        PersonagemDTO dto = new PersonagemDTO();
        when(personagemRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<PersonagemDTO> result = personagemService.atualizar(1L, dto);

        assertFalse(result.isPresent());
    }

    @Test
    void testDeletarFound() {
        when(personagemRepository.existsById(1L)).thenReturn(true);

        boolean result = personagemService.deletar(1L);

        assertTrue(result);
        verify(personagemRepository).deleteById(1L);
    }

    @Test
    void testDeletarNotFound() {
        when(personagemRepository.existsById(1L)).thenReturn(false);

        boolean result = personagemService.deletar(1L);

        assertFalse(result);
        verify(personagemRepository, never()).deleteById(1L);
    }

    @Test
    void testConverterDTOParaEntidadeTipoInvalido() throws Exception {
        PersonagemDTO dto = new PersonagemDTO();
        dto.setTipoNinja("INVALIDO");

        java.lang.reflect.Method method = personagemService.getClass()
                .getDeclaredMethod("converterDTOParaEntidade", PersonagemDTO.class);
        method.setAccessible(true);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            try {
                method.invoke(personagemService, dto);
            } catch (java.lang.reflect.InvocationTargetException e) {
                throw e.getCause();
            }
        });
        assertTrue(ex.getMessage().contains("Tipo de ninja inválido"));
    }

}