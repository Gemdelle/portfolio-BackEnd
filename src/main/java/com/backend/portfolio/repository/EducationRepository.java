package com.backend.portfolio.repository;

import com.backend.portfolio.model.About;
import com.backend.portfolio.model.Education;
import com.backend.portfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    Education findByUser(User user);

}
