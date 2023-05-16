package com.backend.portfolio.dto;

import lombok.Data;

import java.util.List;
@Data
public class ExperienceDTO {
    private String studio_name;
    private String from;
    private String to;
    private String logo;
    private String description;
    private List<RoleDTO> roles;
    private String thumbnail;
    private String thumbnail_url;
}