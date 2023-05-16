package com.backend.portfolio.dto;


import lombok.Data;

import java.util.List;
@Data
public class ProjectDTO {
    private int number;
    private String type;
    private String title;
    private String description;
    private List<String> tags;
    private ProjectDataDTO data;

}
