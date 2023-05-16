package com.backend.portfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "subproject")
@Data
public class Subproject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String background;
    @Column(name = "fccStyleDescription", length = 4000)
    private String fccStyleDescription;
    private String fccStyleUrl;
    @Column(name = "myStyleDescription", length = 4000)
    private String myStyleDescription;
    private String myStyleUrl;
    private String name;
    private int number;
    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Project project;
}
