package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.SkillsDTO;
import com.backend.portfolio.model.Skills;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SkillsMapper {
    SkillsMapper INSTANCE = Mappers.getMapper(SkillsMapper.class);

    SkillsDTO toDto(Skills skills);
}
