package com.backend.portfolio.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "work_experience")
@Data
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studioName;
    @Column(name = "description", length = 10000)
    private String description;
    private String logo;
    private String startDate;
    private String endDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    @OneToMany(mappedBy = "workExperience", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Role> roles;
    private String thumbnail;
    private String thumbnailUrl;
}

