package com.zch.tiny.mapper;

import com.zch.tiny.model.RoleMenu;
import com.zch.tiny.dto.RoleMenuDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMenuMapper {
    RoleMenuMapper INSTANCE = Mappers.getMapper(RoleMenuMapper.class);

    RoleMenu toEntity(RoleMenuDto dto);

    RoleMenuDto toDto(RoleMenu entity);
}
