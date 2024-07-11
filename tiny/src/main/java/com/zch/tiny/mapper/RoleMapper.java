package com.zch.tiny.mapper;

import com.zch.tiny.model.Role;
import com.zch.tiny.dto.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    @Mappings({
        // 忽略 children 字段的映射
        @Mapping(target = "userRoles", ignore = true)
    })
    Role toEntity(RoleDto dto);

    @Mappings({
        // 忽略 children 字段的映射
        @Mapping(target = "userRoles", ignore = true)
    })
    RoleDto toDto(Role entity);
}
