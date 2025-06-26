package com.desafio.narutoI;

import com.desafio.narutoI.dto.PersonagemDTO;
import com.desafio.narutoI.repositories.PersonagemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonagemControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private PersonagemRepository personagemRepository;

	private PersonagemDTO personagemDTO;

	@BeforeEach
	void setUp() {
		personagemRepository.deleteAll();
		personagemDTO = new PersonagemDTO();
		personagemDTO.setNome("Naruto Uzumaki");
		personagemDTO.setIdade(17);
		personagemDTO.setAldeia("Konoha");
		personagemDTO.setChakra(500);
		personagemDTO.setJutsus(Collections.singletonList("Rasengan"));
		personagemDTO.setTipoNinja("NINJUTSU");
	}

	@Test
	void testCRUD() throws Exception {
		String createResponse = mockMvc.perform(post("/api/personagens")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(personagemDTO)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.nome").value("Naruto Uzumaki"))
				.andExpect(jsonPath("$.id").exists())
				.andReturn()
				.getResponse()
				.getContentAsString();

		Long id = objectMapper.readTree(createResponse).get("id").asLong();
		assertThat(id).isNotNull();

		mockMvc.perform(get("/api/personagens"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(1))
				.andExpect(jsonPath("$[0].nome").value("Naruto Uzumaki"));

		mockMvc.perform(get("/api/personagens/{id}", id))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.nome").value("Naruto Uzumaki"));

		personagemDTO.setNome("Naruto Hokage");
		personagemDTO.setChakra(999);
		personagemDTO.setTipoNinja("NINJUTSU");

		mockMvc.perform(put("/api/personagens/{id}", id)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(personagemDTO)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.nome").value("Naruto Hokage"))
				.andExpect(jsonPath("$.chakra").value(999));

		mockMvc.perform(delete("/api/personagens/{id}", id))
				.andExpect(status().isNoContent());

		mockMvc.perform(get("/api/personagens"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(0));
	}
}