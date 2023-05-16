package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.AcademyDTO;
import com.backend.portfolio.model.Academy;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T22:42:17-0300",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class AcademyMapperImpl implements AcademyMapper {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public AcademyDTO toDto(Academy academy) {
        if ( academy == null ) {
            return null;
        }

        AcademyDTO academyDTO = new AcademyDTO();

        academyDTO.setCourses( courseMapper.toDtoList( academy.getCourses() ) );
        academyDTO.setName( academy.getName() );
        academyDTO.setShield( academy.getShield() );
        academyDTO.setLogo( academy.getLogo() );

        return academyDTO;
    }

    @Override
    public Academy toEntity(AcademyDTO academyDTO) {
        if ( academyDTO == null ) {
            return null;
        }

        Academy academy = new Academy();

        academy.setCourses( courseMapper.toEntityList( academyDTO.getCourses() ) );
        academy.setName( academyDTO.getName() );
        academy.setShield( academyDTO.getShield() );
        academy.setLogo( academyDTO.getLogo() );

        return academy;
    }

    @Override
    public List<AcademyDTO> toDtoList(List<Academy> academies) {
        if ( academies == null ) {
            return null;
        }

        List<AcademyDTO> list = new ArrayList<AcademyDTO>( academies.size() );
        for ( Academy academy : academies ) {
            list.add( toDto( academy ) );
        }

        return list;
    }

    @Override
    public List<Academy> toEntityList(List<AcademyDTO> academyDTOs) {
        if ( academyDTOs == null ) {
            return null;
        }

        List<Academy> list = new ArrayList<Academy>( academyDTOs.size() );
        for ( AcademyDTO academyDTO : academyDTOs ) {
            list.add( toEntity( academyDTO ) );
        }

        return list;
    }
}
