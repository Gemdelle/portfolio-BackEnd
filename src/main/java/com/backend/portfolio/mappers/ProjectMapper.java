package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.ProjectDTO;
import com.backend.portfolio.dto.ProjectDataDTO;
import com.backend.portfolio.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Mapper(componentModel = "spring", uses = {SubprojectMapper.class})
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mapping(source = "projectUrl", target = "data.project_url")
    @Mapping(source = "background", target = "data.background")
    @Mapping(source = "subprojects", target = "data.subprojects")

    ProjectDTO toDto(Project project);
}
