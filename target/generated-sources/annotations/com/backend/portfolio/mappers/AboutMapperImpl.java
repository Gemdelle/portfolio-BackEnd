package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.AboutDTO;
import com.backend.portfolio.model.About;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T22:42:16-0300",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class AboutMapperImpl implements AboutMapper {

    @Override
    public AboutDTO aboutToDTO(About about) {
        if ( about == null ) {
            return null;
        }

        AboutDTO aboutDTO = new AboutDTO();

        aboutDTO.setBanner_url( about.getBannerUrl() );
        aboutDTO.setCreativity_description( about.getCreativityDescription() );
        aboutDTO.setLogic_description( about.getLogicDescription() );
        aboutDTO.setProfile_picture_url( about.getProfilePictureUrl() );
        aboutDTO.setProfile_title( about.getProfileTitle() );

        return aboutDTO;
    }
}
