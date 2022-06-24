package org.cory.rice.bingetv.mappers;

import org.cory.rice.bingetv.dto.ShowsDto;
import org.cory.rice.bingetv.models.Shows;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ShowMapper {

		
		ShowMapper INSTANCE= Mappers.getMapper(ShowMapper.class);
		ShowsDto modelToDto(Shows shows);
		Shows dtoToModel(ShowsDto showsDto);
		
	}
