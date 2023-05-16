package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.ExperienceDTO;
import com.backend.portfolio.model.WorkExperience;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T22:42:16-0300",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class ExperienceMapperImpl implements ExperienceMapper {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public ExperienceDTO toDto(WorkExperience experience) {
        if ( experience == null ) {
            return null;
        }

        ExperienceDTO experienceDTO = new ExperienceDTO();

        experienceDTO.setStudio_name( experience.getStudioName() );
        experienceDTO.setFrom( experience.getStartDate() );
        experienceDTO.setTo( experience.getEndDate() );
        experienceDTO.setRoles( roleMapper.toDtoList( experience.getRoles() ) );
        experienceDTO.setThumbnail( experience.getThumbnail() );
        experienceDTO.setThumbnail_url( experience.getThumbnailUrl() );
        experienceDTO.setLogo( experience.getLogo() );
        experienceDTO.setDescription( experience.getDescription() );

        return experienceDTO;
    }
}
