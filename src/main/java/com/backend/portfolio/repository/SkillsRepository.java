package com.backend.portfolio.repository;

import com.backend.portfolio.model.Skill;
import com.backend.portfolio.model.Skills;
import com.backend.portfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long> {

    Skills findByUser(User user);

}
