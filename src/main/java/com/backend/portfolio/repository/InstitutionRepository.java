package com.backend.portfolio.repository;

import com.backend.portfolio.model.Education;
import com.backend.portfolio.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    List<Institution> findByEducation(Education education);
}
