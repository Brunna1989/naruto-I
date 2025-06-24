package com.desafio.narutoI.mapper;

import com.desafio.narutoI.dto.PersonagemDTO;
import com.desafio.narutoI.entidades.NinjaDeGenjutsu;
import com.desafio.narutoI.entidades.NinjaDeNinjutsu;
import com.desafio.narutoI.entidades.NinjaDeTaijutsu;
import com.desafio.narutoI.entidades.Personagem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonagemMapper {

    PersonagemMapper INSTANCE = Mappers.getMapper(PersonagemMapper.class);

    PersonagemDTO toDTO(Personagem personagem);

    PersonagemDTO toDTO(NinjaDeNinjutsu personagem);

    PersonagemDTO toDTO(NinjaDeGenjutsu personagem);

    PersonagemDTO toDTO(NinjaDeTaijutsu personagem);

    NinjaDeNinjutsu toEntity(PersonagemDTO dto);
}