package com.backend.portfolio.repository;

import com.backend.portfolio.model.Academy;
import com.backend.portfolio.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByAcademy(Academy academy);

    void deleteAllByAcademy(Academy academy);

}
