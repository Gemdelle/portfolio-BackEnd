package com.backend.portfolio.repository;

import com.backend.portfolio.model.About;
import com.backend.portfolio.model.Academy;
import com.backend.portfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long> {
    List<Academy> findByUser(User user);

}
