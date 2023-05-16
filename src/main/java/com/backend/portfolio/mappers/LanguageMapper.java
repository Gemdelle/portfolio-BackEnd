package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.LanguageDTO;
import com.backend.portfolio.model.Language;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface LanguageMapper {
    LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);

    @Mapping(source = "backgroundD", target = "background")
    @Mapping(source = "emptyD", target = "empty")
    LanguageDTO toDto(Language language);
}
