package com.backend.portfolio.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "language")
@Data
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String backgroundD;
    private int level;
    private String title;
    private String certificate;
    private String full;
    private String emptyD;
    @ManyToOne
    @JoinColumn(name = "education_id")
    @JsonBackReference
    private Education education;
}