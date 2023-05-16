package com.backend.portfolio.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "education")
@Data
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Institution> institutions;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Language> languages;
}