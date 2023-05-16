package com.backend.portfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "about")
@Data
@EqualsAndHashCode(exclude = "user")
public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    private String bannerUrl;
    private String creativityDescription;
    private String logicDescription;
    private String profilePictureUrl;
    private String profileTitle;


    @Override
    public int hashCode() {
        return Objects.hash(id, bannerUrl, creativityDescription, logicDescription, profilePictureUrl, profileTitle);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof About)) {
            return false;
        }
        About other = (About) obj;
        return Objects.equals(id, other.id) &&
                Objects.equals(bannerUrl, other.bannerUrl) &&
                Objects.equals(creativityDescription, other.creativityDescription) &&
                Objects.equals(logicDescription, other.logicDescription) &&
                Objects.equals(profilePictureUrl, other.profilePictureUrl) &&
                Objects.equals(profileTitle, other.profileTitle);
    }
}
