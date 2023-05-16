package com.backend.portfolio.repository;

import com.backend.portfolio.model.Role;
import com.backend.portfolio.model.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByWorkExperience(WorkExperience workExperience);
}
