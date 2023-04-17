package org.cory.rice.bingetv.mappers;

import org.cory.rice.bingetv.dto.UserDto;
import org.cory.rice.bingetv.models.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = ShowMapper.class)
public interface UserMapper {
	//	handles mapping models to dto to lessen code with MapStruct
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserDto modelToDto(Users users);
	
	Users dtoToModel(UserDto userDto);
}
