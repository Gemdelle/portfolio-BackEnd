package com.backend.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(exclude = {"about", "education", "workExperience", "academies", "projects", "skills"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    @Column(updatable = false)
    private Instant registrationDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private About about;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JoinColumn(name = "education_id")
    @JsonManagedReference
    private Education education;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference
    private WorkExperience workExperience;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Academy> academies;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Project> projects;
    @OneToOne
    @JsonManagedReference
    private Skills skills;

    @PrePersist
    public void prePersist() {
        registrationDate = Instant.now();
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, emailAddress, password, registrationDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        return Objects.equals(id, other.id) &&
                Objects.equals(firstName, other.firstName) &&
                Objects.equals(lastName, other.lastName) &&
                Objects.equals(emailAddress, other.emailAddress) &&
                Objects.equals(password, other.password) &&
                Objects.equals(registrationDate, other.registrationDate);
    }
}
