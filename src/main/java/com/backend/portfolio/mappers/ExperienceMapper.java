package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.ExperienceDTO;
import com.backend.portfolio.model.WorkExperience;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface ExperienceMapper {
    ExperienceMapper INSTANCE = Mappers.getMapper(ExperienceMapper.class);

    @Mapping(source = "studioName", target = "studio_name")
    @Mapping(source = "startDate", target = "from")
    @Mapping(source = "endDate", target = "to")
    @Mapping(source = "roles", target = "roles")
    @Mapping(source = "thumbnail", target = "thumbnail")
    @Mapping(source = "thumbnailUrl", target = "thumbnail_url")
    ExperienceDTO toDto(WorkExperience experience);

}
