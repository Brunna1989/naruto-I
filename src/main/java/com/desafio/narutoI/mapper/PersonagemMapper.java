package com.desafio.narutoI.mapper;

import com.desafio.narutoI.dto.PersonagemDTO;
import com.desafio.narutoI.entidades.NinjaDeNinjutsu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonagemMapper {

    PersonagemMapper INSTANCE = Mappers.getMapper(PersonagemMapper.class);

    PersonagemDTO toDTO(NinjaDeNinjutsu personagem);

    NinjaDeNinjutsu toEntity(PersonagemDTO dto);
}