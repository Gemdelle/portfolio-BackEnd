package com.backend.portfolio.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
public class AcademyDTO {
    private String name;
    private String shield;
    private String logo;
    private List<CourseDTO> courses;
}
