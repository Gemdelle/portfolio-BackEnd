package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.AcademyDTO;
import com.backend.portfolio.dto.UserDTO;
import com.backend.portfolio.model.Academy;
import com.backend.portfolio.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Mapper(componentModel = "spring", uses = {AboutMapper.class, ExperienceMapper.class, EducationMapper.class, AcademyMapper.class, SkillsMapper.class, ProjectMapper.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "about", target = "about")
    @Mapping(source = "workExperience", target = "experience")
    @Mapping(source = "education", target = "education")
    @Mapping(source = "academies", target = "academies")
    @Mapping(source = "skills", target = "skills")
    @Mapping(source = "projects", target = "projects")
    UserDTO toDto(User user);

}

