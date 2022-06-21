package org.cory.rice.bingetv.mappers;

;
import org.cory.rice.bingetv.dto.UserDto;
import org.cory.rice.bingetv.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface UserMapper {
	
	org.cory.rice.bingetv.mappers.ShowMapper INSTANCE= Mappers.getMapper(ShowMapper.class);
	UserDto modelToDto(User user);
	User dtoToModel(UserDto userDto);
}
