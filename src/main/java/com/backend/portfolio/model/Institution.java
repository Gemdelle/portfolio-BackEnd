package com.backend.portfolio.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "institution")
@Data
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logo;
    private String name;
    private String from_date;
    private String to_date;
    private String title;
    private String certificate;
    @ManyToOne
    @JoinColumn(name = "education_id")
    @JsonBackReference
    private Education education;
}