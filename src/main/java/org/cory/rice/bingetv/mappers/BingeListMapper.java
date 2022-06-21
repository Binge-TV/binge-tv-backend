package org.cory.rice.bingetv.mappers;


import org.cory.rice.bingetv.dto.BingedListDto;
import org.cory.rice.bingetv.dto.ShowsDto;
import org.cory.rice.bingetv.dto.UserDto;
import org.cory.rice.bingetv.models.BingedList;


import org.cory.rice.bingetv.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BingeListMapper {
//
//	@Mapping(source = "userDto.bingedlist", target = "bingedlist")
//	@Mapping(source = "showsDto.bingedlist", target = "bingedList")
//	@Mapping(source = "bingedList.bShows", target = "bShows")
	BingedList setUsersBingeList(UserDto userDto,  BingedListDto bingedListDto);
	BingedListDto setBingeListToUsers(User user, BingedList bingedList);
}
