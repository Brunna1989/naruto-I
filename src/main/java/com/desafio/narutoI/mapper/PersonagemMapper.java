package com.desafio.narutoI.mapper;

import com.desafio.narutoI.dto.PersonagemDTO;
import com.desafio.narutoI.entidades.NinjaDeGenjutsu;
import com.desafio.narutoI.entidades.NinjaDeNinjutsu;
import com.desafio.narutoI.entidades.NinjaDeTaijutsu;
import com.desafio.narutoI.entidades.Personagem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonagemMapper {
    PersonagemDTO toDTO(Personagem personagem);
    NinjaDeNinjutsu toEntity(PersonagemDTO dto);
    NinjaDeGenjutsu toGenjutsuEntity(PersonagemDTO dto);
    NinjaDeTaijutsu toTaijutsuEntity(PersonagemDTO dto);
}