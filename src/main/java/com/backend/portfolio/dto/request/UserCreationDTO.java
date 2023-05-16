package com.backend.portfolio.dto.request;

import com.backend.portfolio.dto.*;
import lombok.Data;

import java.util.List;

@Data
public class UserCreationDTO {
    private AboutDTO about;
    private EducationDTO education;
    private List<AcademyDTO> academies;
    private List<ProjectDTO> projects;
    private ExperienceDTO experience;
    private SkillsDTO skills;
}