package com.backend.portfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "course")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "description", length = 4000)
    private String description;
    private String certificate;
    @ManyToOne
    @JoinColumn(name = "academy_id")
    @JsonBackReference
    private Academy academy;
}
