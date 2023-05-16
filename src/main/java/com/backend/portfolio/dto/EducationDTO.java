package com.backend.portfolio.dto;

import lombok.Data;

import java.util.List;
@Data
public class EducationDTO {
    private List<InstitutionDTO> institutions;
    private List<LanguageDTO> languages;
}
