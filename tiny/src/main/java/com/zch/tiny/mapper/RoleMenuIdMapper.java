package com.zch.tiny.mapper;

import com.zch.tiny.model.RoleMenuId;
import com.zch.tiny.dto.RoleMenuIdDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMenuIdMapper {
    RoleMenuIdMapper INSTANCE = Mappers.getMapper(RoleMenuIdMapper.class);

    RoleMenuId toEntity(RoleMenuIdDto dto);

    RoleMenuIdDto toDto(RoleMenuId entity);
}
