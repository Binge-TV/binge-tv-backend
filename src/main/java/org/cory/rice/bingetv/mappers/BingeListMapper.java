package org.cory.rice.bingetv.mappers;

import org.cory.rice.bingetv.dto.BingeListDto;
import org.cory.rice.bingetv.models.BingeList;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BingeListMapper {

        //	handles mapping models to dto to lessen code with MapStruct
        BingeListMapper INSTANCE = Mappers.getMapper(BingeListMapper.class);

        BingeListDto modelToDto(BingeList bingeList);

        BingeList dtoToModel(BingeListDto bingeListDto);
}
