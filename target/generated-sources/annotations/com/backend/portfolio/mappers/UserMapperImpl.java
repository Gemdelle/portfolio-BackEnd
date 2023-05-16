package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.ProjectDTO;
import com.backend.portfolio.dto.UserDTO;
import com.backend.portfolio.model.Project;
import com.backend.portfolio.model.User;
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
public class UserMapperImpl implements UserMapper {

    @Autowired
    private AboutMapper aboutMapper;
    @Autowired
    private ExperienceMapper experienceMapper;
    @Autowired
    private EducationMapper educationMapper;
    @Autowired
    private AcademyMapper academyMapper;
    @Autowired
    private SkillsMapper skillsMapper;
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public UserDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setAbout( aboutMapper.aboutToDTO( user.getAbout() ) );
        userDTO.setExperience( experienceMapper.toDto( user.getWorkExperience() ) );
        userDTO.setEducation( educationMapper.toDto( user.getEducation() ) );
        userDTO.setAcademies( academyMapper.toDtoList( user.getAcademies() ) );
        userDTO.setSkills( skillsMapper.toDto( user.getSkills() ) );
        userDTO.setProjects( projectListToProjectDTOList( user.getProjects() ) );

        return userDTO;
    }

    protected List<ProjectDTO> projectListToProjectDTOList(List<Project> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjectDTO> list1 = new ArrayList<ProjectDTO>( list.size() );
        for ( Project project : list ) {
            list1.add( projectMapper.toDto( project ) );
        }

        return list1;
    }
}
