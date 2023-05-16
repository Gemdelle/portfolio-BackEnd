package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.ProjectDTO;
import com.backend.portfolio.dto.ProjectDataDTO;
import com.backend.portfolio.dto.SubprojectDTO;
import com.backend.portfolio.model.Project;
import com.backend.portfolio.model.Subproject;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T22:42:16-0300",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Autowired
    private SubprojectMapper subprojectMapper;

    @Override
    public ProjectDTO toDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDTO projectDTO = new ProjectDTO();

        projectDTO.setData( projectToProjectDataDTO( project ) );
        if ( project.getNumber() != null ) {
            projectDTO.setNumber( Integer.parseInt( project.getNumber() ) );
        }
        projectDTO.setType( project.getType() );
        projectDTO.setTitle( project.getTitle() );
        projectDTO.setDescription( project.getDescription() );
        List<String> list = project.getTags();
        if ( list != null ) {
            projectDTO.setTags( new ArrayList<String>( list ) );
        }

        return projectDTO;
    }

    protected List<SubprojectDTO> subprojectListToSubprojectDTOList(List<Subproject> list) {
        if ( list == null ) {
            return null;
        }

        List<SubprojectDTO> list1 = new ArrayList<SubprojectDTO>( list.size() );
        for ( Subproject subproject : list ) {
            list1.add( subprojectMapper.toDto( subproject ) );
        }

        return list1;
    }

    protected ProjectDataDTO projectToProjectDataDTO(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDataDTO projectDataDTO = new ProjectDataDTO();

        projectDataDTO.setProject_url( project.getProjectUrl() );
        projectDataDTO.setBackground( project.getBackground() );
        projectDataDTO.setSubprojects( subprojectListToSubprojectDTOList( project.getSubprojects() ) );

        return projectDataDTO;
    }
}
