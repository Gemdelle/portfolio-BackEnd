package com.backend.portfolio.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "skill")
@Data
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String background;
    private String level;
    @ElementCollection
    private List<String> abilities;
    @Column(name = "description", length = 4000)
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    @ManyToOne
    @JoinColumn(name = "skills_id")
    @JsonBackReference
    private Skills skills;
}