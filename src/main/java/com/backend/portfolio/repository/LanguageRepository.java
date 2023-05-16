package com.backend.portfolio.repository;

import com.backend.portfolio.model.Education;
import com.backend.portfolio.model.Institution;
import com.backend.portfolio.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    List<Language> findByEducation(Education education);

}
