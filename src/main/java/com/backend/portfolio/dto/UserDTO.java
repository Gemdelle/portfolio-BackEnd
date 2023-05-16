package com.backend.portfolio.dto;


import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private AboutDTO about;
    private ExperienceDTO experience;
    private EducationDTO education;
    private List<AcademyDTO> academies;
    private SkillsDTO skills;
    private List<ProjectDTO> projects;
}