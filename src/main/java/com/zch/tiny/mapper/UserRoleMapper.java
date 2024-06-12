package com.zch.tiny.mapper;

import com.zch.tiny.model.UserRole;
import com.zch.tiny.dto.UserRoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRoleMapper {
    UserRoleMapper INSTANCE = Mappers.getMapper(UserRoleMapper.class);

    UserRole toEntity(UserRoleDto dto);

    UserRoleDto toDto(UserRole entity);
}
