package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.SkillDTO;
import com.backend.portfolio.model.Skill;
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
public class SkillMapperImpl implements SkillMapper {

    @Override
    public SkillDTO toDto(Skill skill) {
        if ( skill == null ) {
            return null;
        }

        SkillDTO skillDTO = new SkillDTO();

        skillDTO.setName( skill.getName() );
        skillDTO.setBackground( skill.getBackground() );
        skillDTO.setLevel( skill.getLevel() );
        List<String> list = skill.getAbilities();
        if ( list != null ) {
            skillDTO.setAbilities( new ArrayList<String>( list ) );
        }
        skillDTO.setDescription( skill.getDescription() );

        return skillDTO;
    }
}
