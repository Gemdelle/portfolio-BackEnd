package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.InstitutionDTO;
import com.backend.portfolio.model.Institution;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface InstitutionMapper {
    InstitutionMapper INSTANCE = Mappers.getMapper(InstitutionMapper.class);

    @Mapping(source = "from_date", target = "from")
    @Mapping(source = "to_date", target = "to")
    InstitutionDTO toDto(Institution institution);
}

