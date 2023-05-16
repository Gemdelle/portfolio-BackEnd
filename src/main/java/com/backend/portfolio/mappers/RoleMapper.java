package com.backend.portfolio.mappers;

import com.backend.portfolio.dto.RoleDTO;
import com.backend.portfolio.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDTO toDto(Role role);
    List<RoleDTO> toDtoList(List<Role> roles);
}
