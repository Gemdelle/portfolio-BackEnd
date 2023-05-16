package com.backend.portfolio.service;

import com.backend.portfolio.dto.AcademyDTO;

import java.util.Optional;

public interface AcademyService {

    Optional<AcademyDTO> getAcademyById(Long academyId);
}
