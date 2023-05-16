package com.backend.portfolio.repository;
import com.backend.portfolio.model.User;
import com.backend.portfolio.model.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long> {

    WorkExperience findByUser(User user);
}
