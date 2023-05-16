package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.AcademyDTO;
import com.backend.portfolio.dto.CourseDTO;
import com.backend.portfolio.model.Academy;
import com.backend.portfolio.model.Course;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = {CourseMapper.class})
public interface AcademyMapper {
    AcademyMapper INSTANCE = Mappers.getMapper(AcademyMapper.class);

    @Mapping(source = "courses", target = "courses")
    AcademyDTO toDto(Academy academy);

    @Mapping(source = "courses", target = "courses")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Academy toEntity(AcademyDTO academyDTO);

    List<AcademyDTO> toDtoList(List<Academy> academies);
    List<Academy> toEntityList(List<AcademyDTO> academyDTOs);
}
