package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.CourseDTO;
import com.backend.portfolio.model.Course;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T22:29:30-0300",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public CourseDTO toDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();

        courseDTO.setName( course.getName() );
        courseDTO.setDescription( course.getDescription() );
        courseDTO.setCertificate( course.getCertificate() );

        return courseDTO;
    }

    @Override
    public Course toEntity(CourseDTO courseDTO) {
        if ( courseDTO == null ) {
            return null;
        }

        Course course = new Course();

        course.setName( courseDTO.getName() );
        course.setDescription( courseDTO.getDescription() );
        course.setCertificate( courseDTO.getCertificate() );

        return course;
    }

    @Override
    public List<Course> toEntityList(List<CourseDTO> courseDTOs) {
        if ( courseDTOs == null ) {
            return null;
        }

        List<Course> list = new ArrayList<Course>( courseDTOs.size() );
        for ( CourseDTO courseDTO : courseDTOs ) {
            list.add( toEntity( courseDTO ) );
        }

        return list;
    }
}
