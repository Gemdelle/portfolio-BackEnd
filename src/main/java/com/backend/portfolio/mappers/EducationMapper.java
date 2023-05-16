package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.EducationDTO;
import com.backend.portfolio.model.Education;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = {InstitutionMapper.class, LanguageMapper.class})
public interface EducationMapper {
    EducationMapper INSTANCE = Mappers.getMapper(EducationMapper.class);

    EducationDTO toDto(Education education);
}
