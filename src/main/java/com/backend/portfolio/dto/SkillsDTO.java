package com.backend.portfolio.dto;

import lombok.Data;

import java.util.List;
@Data
public class SkillsDTO {
    private List<SkillDTO> hard;
    private List<SkillDTO> soft;

}
