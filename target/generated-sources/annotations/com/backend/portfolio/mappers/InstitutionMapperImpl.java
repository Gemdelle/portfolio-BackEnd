package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.InstitutionDTO;
import com.backend.portfolio.model.Institution;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T22:42:17-0300",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class InstitutionMapperImpl implements InstitutionMapper {

    @Override
    public InstitutionDTO toDto(Institution institution) {
        if ( institution == null ) {
            return null;
        }

        InstitutionDTO institutionDTO = new InstitutionDTO();

        institutionDTO.setFrom( institution.getFrom_date() );
        institutionDTO.setTo( institution.getTo_date() );
        institutionDTO.setLogo( institution.getLogo() );
        institutionDTO.setName( institution.getName() );
        institutionDTO.setTitle( institution.getTitle() );
        institutionDTO.setCertificate( institution.getCertificate() );

        return institutionDTO;
    }
}
