package com.zch.tiny.mapper;

import com.zch.tiny.model.Permission;
import com.zch.tiny.dto.PermissionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PermissionMapper {
    PermissionMapper INSTANCE = Mappers.getMapper(PermissionMapper.class);

    Permission toEntity(PermissionDto dto);

    PermissionDto toDto(Permission entity);
}
