package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.SkillDTO;
import com.backend.portfolio.dto.SkillsDTO;
import com.backend.portfolio.model.Skill;
import com.backend.portfolio.model.Skills;
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
public class SkillsMapperImpl implements SkillsMapper {

    @Override
    public SkillsDTO toDto(Skills skills) {
        if ( skills == null ) {
            return null;
        }

        SkillsDTO skillsDTO = new SkillsDTO();

        skillsDTO.setHard( skillListToSkillDTOList( skills.getHard() ) );
        skillsDTO.setSoft( skillListToSkillDTOList( skills.getSoft() ) );

        return skillsDTO;
    }

    protected SkillDTO skillToSkillDTO(Skill skill) {
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

    protected List<SkillDTO> skillListToSkillDTOList(List<Skill> list) {
        if ( list == null ) {
            return null;
        }

        List<SkillDTO> list1 = new ArrayList<SkillDTO>( list.size() );
        for ( Skill skill : list ) {
            list1.add( skillToSkillDTO( skill ) );
        }

        return list1;
    }
}
