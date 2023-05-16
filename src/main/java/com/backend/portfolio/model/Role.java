package com.backend.portfolio.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "description", length = 4000)
    private String description;
    @ManyToOne
    @JoinColumn(name = "work_experience_id")
    @JsonBackReference
    private WorkExperience workExperience;
}
