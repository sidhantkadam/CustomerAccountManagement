package com.sid.project.SpringBoot_Cards.ModelMapper;

import com.sid.project.SpringBoot_Cards.DTO.CardDTO;
import com.sid.project.SpringBoot_Cards.Entity.Cards;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ModelMapper
{

    Cards cardsDtoToEntity(CardDTO cardDTO);

    CardDTO cardEntityToDto(Cards cards);
}
