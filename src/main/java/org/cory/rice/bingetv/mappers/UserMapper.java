package org.cory.rice.bingetv.mappers;

import org.cory.rice.bingetv.dto.UserDto;
import org.cory.rice.bingetv.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

;

@Mapper(componentModel = "spring", uses = ShowMapper.class)
public interface UserMapper {
	//	handles mapping models to dto to lessen code with MapStruct
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserDto modelToDto(User user);
	
	User dtoToModel(UserDto userDto);
}
