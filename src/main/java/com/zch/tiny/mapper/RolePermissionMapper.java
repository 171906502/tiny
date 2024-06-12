package com.zch.tiny.mapper;

import com.zch.tiny.model.RolePermission;
import com.zch.tiny.dto.RolePermissionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RolePermissionMapper {
    RolePermissionMapper INSTANCE = Mappers.getMapper(RolePermissionMapper.class);

    RolePermission toEntity(RolePermissionDto dto);

    RolePermissionDto toDto(RolePermission entity);
}
