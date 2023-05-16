package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.AboutDTO;
import com.backend.portfolio.model.About;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AboutMapper {
    AboutMapper INSTANCE = Mappers.getMapper(AboutMapper.class);
    @Mapping(source = "bannerUrl", target = "banner_url")
    @Mapping(source = "creativityDescription", target = "creativity_description")
    @Mapping(source = "logicDescription", target = "logic_description")
    @Mapping(source = "profilePictureUrl", target = "profile_picture_url")
    @Mapping(source = "profileTitle", target = "profile_title")
    AboutDTO aboutToDTO(About about);

}