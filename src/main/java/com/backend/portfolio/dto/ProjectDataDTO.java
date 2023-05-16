package com.backend.portfolio.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectDataDTO {
    private String project_url;
    private String background;
    private List<SubprojectDTO> subprojects;
}

