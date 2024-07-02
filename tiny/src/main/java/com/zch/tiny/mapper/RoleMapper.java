package com.zch.tiny.mapper;

import com.zch.tiny.model.Role;
import com.zch.tiny.dto.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role toEntity(RoleDto dto);

    RoleDto toDto(Role entity);
}
