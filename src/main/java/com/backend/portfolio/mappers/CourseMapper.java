package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.CourseDTO;
import com.backend.portfolio.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDTO toDto(Course course);
    Course toEntity(CourseDTO courseDTO);
    List<Course> toEntityList(List<CourseDTO> courseDTOs);

    default List<CourseDTO> toDtoList(List<Course> courses) {
        return courses.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
