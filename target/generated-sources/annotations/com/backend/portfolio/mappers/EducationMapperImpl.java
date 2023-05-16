package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.EducationDTO;
import com.backend.portfolio.dto.InstitutionDTO;
import com.backend.portfolio.dto.LanguageDTO;
import com.backend.portfolio.model.Education;
import com.backend.portfolio.model.Institution;
import com.backend.portfolio.model.Language;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T23:10:41-0300",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class EducationMapperImpl implements EducationMapper {

    @Autowired
    private InstitutionMapper institutionMapper;
    @Autowired
    private LanguageMapper languageMapper;

    @Override
    public EducationDTO toDto(Education education) {
        if ( education == null ) {
            return null;
        }

        EducationDTO educationDTO = new EducationDTO();

        educationDTO.setInstitutions( institutionListToInstitutionDTOList( education.getInstitutions() ) );
        educationDTO.setLanguages( languageListToLanguageDTOList( education.getLanguages() ) );

        return educationDTO;
    }

    protected List<InstitutionDTO> institutionListToInstitutionDTOList(List<Institution> list) {
        if ( list == null ) {
            return null;
        }

        List<InstitutionDTO> list1 = new ArrayList<InstitutionDTO>( list.size() );
        for ( Institution institution : list ) {
            list1.add( institutionMapper.toDto( institution ) );
        }

        return list1;
    }

    protected List<LanguageDTO> languageListToLanguageDTOList(List<Language> list) {
        if ( list == null ) {
            return null;
        }

        List<LanguageDTO> list1 = new ArrayList<LanguageDTO>( list.size() );
        for ( Language language : list ) {
            list1.add( languageMapper.toDto( language ) );
        }

        return list1;
    }
}
