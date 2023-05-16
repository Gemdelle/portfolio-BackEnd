package com.backend.portfolio.repository;

import com.backend.portfolio.model.Project;
import com.backend.portfolio.model.Subproject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubProjectRepository extends JpaRepository<Subproject, Long> {
    List<Subproject> findByProject(Project project);

    void deleteAllByProject(Project project);


}
