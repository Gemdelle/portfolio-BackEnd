package com.backend.portfolio.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "project")
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String type;
    private String title;
    @Column(name = "description", length = 4000)
    private String description;
    private String projectUrl;
    private String background;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    @ElementCollection
    private List<String> tags;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Subproject> subprojects;
}
