package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.SubprojectDTO;
import com.backend.portfolio.model.Subproject;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T23:10:41-0300",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class SubprojectMapperImpl implements SubprojectMapper {

    @Override
    public SubprojectDTO toDto(Subproject subproject) {
        if ( subproject == null ) {
            return null;
        }

        SubprojectDTO subprojectDTO = new SubprojectDTO();

        subprojectDTO.setBackground( subproject.getBackground() );
        subprojectDTO.setFcc_style_description( subproject.getFccStyleDescription() );
        subprojectDTO.setFcc_style_url( subproject.getFccStyleUrl() );
        subprojectDTO.setMy_style_description( subproject.getMyStyleDescription() );
        subprojectDTO.setMy_style_url( subproject.getMyStyleUrl() );
        subprojectDTO.setName( subproject.getName() );
        subprojectDTO.setNumber( subproject.getNumber() );

        return subprojectDTO;
    }
}
