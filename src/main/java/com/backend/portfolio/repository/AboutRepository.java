package com.backend.portfolio.repository;

import com.backend.portfolio.model.About;
import com.backend.portfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AboutRepository extends JpaRepository<About, Long> {
    About findByUser(User user);

}
