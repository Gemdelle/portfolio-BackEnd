package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.LanguageDTO;
import com.backend.portfolio.model.Language;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T23:10:41-0300",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class LanguageMapperImpl implements LanguageMapper {

    @Override
    public LanguageDTO toDto(Language language) {
        if ( language == null ) {
            return null;
        }

        LanguageDTO languageDTO = new LanguageDTO();

        languageDTO.setBackground( language.getBackgroundD() );
        languageDTO.setEmpty( language.getEmptyD() );
        languageDTO.setName( language.getName() );
        languageDTO.setLevel( language.getLevel() );
        languageDTO.setTitle( language.getTitle() );
        languageDTO.setCertificate( language.getCertificate() );
        languageDTO.setFull( language.getFull() );

        return languageDTO;
    }
}
