package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.SkillDTO;
import com.backend.portfolio.model.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface SkillMapper {
    SkillMapper INSTANCE = Mappers.getMapper(SkillMapper.class);

    SkillDTO toDto(Skill skill);
}
