package com.desafio.narutoI;

import com.desafio.narutoI.dto.PersonagemDTO;
import com.desafio.narutoI.entidades.NinjaDeNinjutsu;
import com.desafio.narutoI.entidades.Personagem;
import com.desafio.narutoI.mapper.PersonagemMapper;
import com.desafio.narutoI.repositories.PersonagemRepository;
import com.desafio.narutoI.services.PersonagemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PersonagemServiceTest {

    private PersonagemRepository personagemRepository;
    private PersonagemMapper personagemMapper;
    private PersonagemService personagemService;

    @BeforeEach
    void setUp() {
        personagemRepository = mock(PersonagemRepository.class);
        personagemMapper = mock(PersonagemMapper.class);
        personagemService = new PersonagemService(personagemRepository, personagemMapper);
    }

    @Test
    void testFindAll() {
        Personagem personagem = new NinjaDeNinjutsu();
        PersonagemDTO dto = new PersonagemDTO();
        dto.setId(1L);
        when(personagemRepository.findAll()).thenReturn(Arrays.asList(personagem));
        when(personagemMapper.toDTO(personagem)).thenReturn(dto);

        List<PersonagemDTO> result = personagemService.findAll();

        assertEquals(1, result.size());
        verify(personagemRepository).findAll();
        verify(personagemMapper).toDTO(personagem);
    }

    @Test
    void testFindByIdFound() {
        Personagem personagem = new NinjaDeNinjutsu();
        PersonagemDTO dto = new PersonagemDTO();
        dto.setId(1L);
        when(personagemRepository.findById(1L)).thenReturn(Optional.of(personagem));
        when(personagemMapper.toDTO(personagem)).thenReturn(dto);

        PersonagemDTO result = personagemService.findById(1L);

        assertNotNull(result);
        verify(personagemRepository).findById(1L);
        verify(personagemMapper).toDTO(personagem);
    }

    @Test
    void testFindByIdNotFound() {
        when(personagemRepository.findById(1L)).thenReturn(Optional.empty());
        RuntimeException ex = assertThrows(RuntimeException.class, () -> personagemService.findById(1L));
        assertTrue(ex.getMessage().contains("Personagem não encontrado"));
        verify(personagemRepository).findById(1L);
    }

    @Test
    void testSave() {
        PersonagemDTO dto = new PersonagemDTO();
        dto.setNome("Naruto");
        NinjaDeNinjutsu personagem = new NinjaDeNinjutsu();
        personagem.setNome("Naruto");
        NinjaDeNinjutsu saved = new NinjaDeNinjutsu();
        saved.setNome("Naruto");
        PersonagemDTO savedDto = new PersonagemDTO();
        savedDto.setId(1L);
        savedDto.setNome("Naruto");

        when(personagemMapper.toEntity(dto)).thenReturn(personagem);
        when(personagemRepository.save(personagem)).thenReturn(saved);
        when(personagemMapper.toDTO(any(Personagem.class))).thenReturn(savedDto);

        PersonagemDTO result = personagemService.save(dto);

        assertNotNull(result);
        assertEquals("Naruto", result.getNome());
        verify(personagemMapper).toEntity(dto);
        verify(personagemRepository).save(personagem);
        verify(personagemMapper).toDTO(any(Personagem.class));
    }

    @Test
    void testUpdateFound() {
        // Arrange
        Long id = 1L;
        PersonagemDTO personagemDTO = new PersonagemDTO();
        personagemDTO.setNome("Naruto");
        personagemDTO.setIdade(17);
        personagemDTO.setAldeia("Konoha");
        personagemDTO.setChakra(1000);
        personagemDTO.setJutsus(new ArrayList<>());

        Personagem personagemExistente = new NinjaDeNinjutsu();
        personagemExistente.setId(id);
        personagemExistente.setNome("Naruto Antigo");

        Personagem personagemAtualizado = new NinjaDeNinjutsu();
        personagemAtualizado.setId(id);
        personagemAtualizado.setNome("Naruto");
        personagemAtualizado.setIdade(17);
        personagemAtualizado.setAldeia("Konoha");
        personagemAtualizado.setChakra(1000);
        personagemAtualizado.setJutsus(new ArrayList<>());

        PersonagemDTO personagemDTOAtualizado = new PersonagemDTO();
        personagemDTOAtualizado.setId(id);
        personagemDTOAtualizado.setNome("Naruto");
        personagemDTOAtualizado.setIdade(17);
        personagemDTOAtualizado.setAldeia("Konoha");
        personagemDTOAtualizado.setChakra(1000);
        personagemDTOAtualizado.setJutsus(new ArrayList<>());

        when(personagemRepository.findById(id)).thenReturn(Optional.of(personagemExistente));
        when(personagemRepository.save(personagemExistente)).thenReturn(personagemAtualizado);
        when(personagemMapper.toDTO(personagemAtualizado)).thenReturn(personagemDTOAtualizado);

        PersonagemDTO result = personagemService.update(id, personagemDTO);

        assertEquals(personagemDTOAtualizado, result);

        verify(personagemMapper, never()).toEntity(any());

        verify(personagemMapper).toDTO(personagemAtualizado);
    }

    @Test
    void testUpdateNotFound() {
        Long id = 1L;
        PersonagemDTO dto = new PersonagemDTO();
        when(personagemRepository.findById(id)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> personagemService.update(id, dto));
        assertTrue(ex.getMessage().contains("Personagem não encontrado"));
        verify(personagemRepository).findById(id);
    }

    @Test
    void testDeleteFound() {
        Long id = 1L;
        when(personagemRepository.existsById(id)).thenReturn(true);

        personagemService.delete(id);

        verify(personagemRepository).existsById(id);
        verify(personagemRepository).deleteById(id);
    }

    @Test
    void testDeleteNotFound() {
        Long id = 1L;
        when(personagemRepository.existsById(id)).thenReturn(false);

        RuntimeException ex = assertThrows(RuntimeException.class, () -> personagemService.delete(id));
        assertTrue(ex.getMessage().contains("Personagem não encontrado"));
        verify(personagemRepository).existsById(id);
    }
}