package com.backend.portfolio.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "skills")
@Data
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Skill> hard;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Skill> soft;
    @OneToOne(mappedBy = "skills", cascade = CascadeType.ALL)
    @JsonBackReference
    private User user;
}