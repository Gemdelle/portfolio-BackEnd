package com.backend.portfolio.dto;


import lombok.Data;

import java.util.List;
@Data
public class SkillDTO {
    private String name;
    private String background;
    private String level;
    private List<String> abilities;
    private String description;

}
