package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.SubprojectDTO;
import com.backend.portfolio.model.Subproject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SubprojectMapper {
    SubprojectMapper INSTANCE = Mappers.getMapper(SubprojectMapper.class);

    @Mapping(source = "background", target = "background")
    @Mapping(source = "fccStyleDescription", target = "fcc_style_description")
    @Mapping(source = "fccStyleUrl", target = "fcc_style_url")
    @Mapping(source = "myStyleDescription", target = "my_style_description")
    @Mapping(source = "myStyleUrl", target = "my_style_url")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "number", target = "number")

    SubprojectDTO toDto(Subproject subproject);
}
