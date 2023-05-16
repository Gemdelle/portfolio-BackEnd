package com.backend.portfolio.service;

import com.backend.portfolio.dto.AcademyDTO;
import com.backend.portfolio.mappers.AcademyMapper;
import com.backend.portfolio.model.Academy;
import com.backend.portfolio.repository.AcademyRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AcademyServiceImpl implements AcademyService {

    private final AcademyRepository academyRepository;
    private final AcademyMapper academyMapper;

    public AcademyServiceImpl(AcademyRepository academyRepository, AcademyMapper academyMapper) {
        this.academyRepository = academyRepository;
        this.academyMapper = academyMapper;
    }


    @Override
    public Optional<AcademyDTO> getAcademyById(Long academyId) {
        Optional<Academy> academy = academyRepository.findById(academyId);
        return academy.map(academyMapper::toDto);
    }
}
